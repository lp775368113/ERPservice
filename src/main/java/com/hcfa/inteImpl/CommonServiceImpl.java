package com.hcfa.inteImpl;
 
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.hcfa.inte.CommonService;
import com.hcfa.util.CodeUtil;
import com.hcfa.util.JdbcUtil;
import com.hcfa.vo.Para;
import com.hcfa.vo.Vo;

import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.jws.WebService;
 
/**接口实现
 * @作者 Administrator
 * @创建日期 2018/6/23 0023
 * @创建时间 11:26.
 */
@WebService(serviceName = "CommonService",//与前面接口一致
        targetNamespace = "http://www.WebService.demo.example.com",  //与前面接口一致
        endpointInterface = "com.hcfa.inte.CommonService")  //接口地址
@Component
public class CommonServiceImpl implements CommonService {
    @Override
    public String getQueryData(String para) {
		System.out.println(para);
		System.out.println("-----------------");
		JSONObject jsonstr = JSONObject.fromObject(para);
		Para stu=(Para)JSONObject.toBean(jsonstr, Para.class);
		System.out.println(stu);
		HashMap<String, Object> result=new HashMap<String, Object>();
		List<Vo> daylist=new ArrayList<Vo>();
		List<Vo> monthlist=new ArrayList<Vo>();
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = getDaySQL(stu);
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet set = s.executeQuery();
			while (set.next()) {
				String PROD_CODE = set.getString("PROD_CODE");
				String name=set.getString("PROD_NAME");
				String PROD_NAME = CodeUtil.getZW(name);
				String shuliang=set.getString("shuliang");
				String xiaoliang=set.getString("xiaoliang");
				Vo vo=new Vo();
				vo.setName_code(PROD_CODE);
				vo.setShuliang(shuliang);
				vo.setXiaoliang(xiaoliang);
				daylist.add(vo);
			}
			
			Connection conn1 = JdbcUtil.getConnection();
			String sql1 = getMonthSQL(stu);
			PreparedStatement s1 = conn.prepareStatement(sql1);
			ResultSet set1 = s1.executeQuery();
			while (set1.next()) {
				String PROD_CODE = set1.getString("PROD_CODE");
				String name=set1.getString("PROD_NAME");
				String PROD_NAME = CodeUtil.getZW(name);
				String shuliang=set1.getString("shuliang");
				String xiaoliang=set1.getString("xiaoliang");
				Vo vo=new Vo();
				vo.setName_code(PROD_CODE);
				vo.setShuliang(shuliang);
				vo.setXiaoliang(xiaoliang);
				monthlist.add(vo);
			}
			
			result.put("dayData", daylist);
			result.put("monthData", monthlist);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		 JSONObject json = JSONObject.fromObject(result);
		 System.out.println(json);
		return json.toString();
    }
    
    public String getMonthSQL(Para para) {
		String[] xhs=para.getXh().split(",");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		   Calendar calendar = Calendar.getInstance();  
	       calendar.set(Calendar.DATE, 1); 
	       String startdate=sdf.format( calendar.getTime());
	       calendar.roll(Calendar.DATE, -1);
	       String enddate=sdf.format( calendar.getTime());
	       calendar.set(Calendar.DATE, 1); 
	       StringBuffer sql=new StringBuffer();
	        sql.append(" SELECT ");
	        sql.append(" PROD_CODE,PROD_NAME,TO_CHAR ( IN_DATE, 'YYYY-MM' ),SUM( PARTS_ORDERED ) shuliang ,SUM( AMOUNT )  xiaoliang ");
	        sql.append(" FROM ");
	        sql.append(" ( ");
	        sql.append(" SELECT ");
	        sql.append(" A.IN_DATE, ");
	        sql.append(" ( A.PARTS_ORDERED + A.PARTS_ALLOC ) PARTS_ORDERED, ");
	        sql.append(" E.PROD_CODE, ");
	        sql.append(" E.PROD_NAME, ");
	        sql.append(" ROUND ( A.PART_PRICE * A.PARTS_ORDERED, 2 ) AMOUNT  ");
	        sql.append(" FROM ");
	        sql.append(" DATA0017 B, ");
	        sql.append(" DATA0010 C, ");
	        sql.append(" DATA0008 E, ");
	        sql.append(" DATA0008 F, ");
	        sql.append(" DATA0009 G, ");
	        sql.append(" DATA0001 D, ");
	        sql.append(" DATA0060 A  ");
	        sql.append(" WHERE ");
	        sql.append(" A.CUSTOMER_PTR = C.RKEY  ");
	        sql.append(" AND A.INVENTORY_PTR = B.RKEY  ");
	        sql.append(" AND C.SALES_REP_PTR = G.RKEY ( + )  ");
	        sql.append(" AND A.CURRENCY_PTR = D.RKEY  ");
	        sql.append(" AND C.DATA0008_PTR_2 = E.RKEY ( + )  ");
	        sql.append(" AND B.PROD_CODE_SELL_PTR = F.RKEY  ");
	        sql.append(" AND A.SALES_TYPE = 3  ");
	        sql.append(" AND A.SALES_TYPE > 1  ");
	        sql.append(" AND ( ( A.FOC = 0 ) OR ( A.FOC = 1 ) )  ");
	        sql.append(" AND A.STATUS > 0  ");
	        for(int i=0;i<xhs.length;i++) {
				String XH=xhs[i].toUpperCase();
				if(i==0&&(!"".equals(XH))) {
					sql.append(" AND "+"( B.INV_PART_DESCRIPTION_C LIKE '%"+XH+"%' ");
				}else if(i!=0){
					sql.append(" or B.INV_PART_DESCRIPTION_C LIKE '%"+XH+"%' ");
				}
				if(i==xhs.length-1&&(!"".equals(XH))) {
					sql.append(" ) ");
				}
			}
	        sql.append(" AND A.IN_DATE >= TO_DATE ( '"+startdate+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS' )  ");
	        sql.append(" AND A.IN_DATE <= TO_DATE ( '"+enddate+" 23:59:59', 'YYYY-MM-DD HH24:MI:SS' )  ");
	        sql.append(" AND A.STATUS <> 4  ");
	        sql.append(" UNION ALL ");
	        sql.append(" SELECT ");
	        sql.append(" A.IN_DATE, ");
	        sql.append(" ( - A.RMA_QTY ) PARTS_ORDERED, ");
	        sql.append(" F.PROD_CODE, ");
	        sql.append(" F.PROD_NAME,- ROUND ( A.UNIT_PRICE * A.RMA_QTY, 2 ) AMOUNT  ");
	        sql.append(" FROM ");
	        sql.append(" DATA0098 A, ");
	        sql.append(" DATA0010 B, ");
	        sql.append(" DATA0017 D, ");
	        sql.append(" DATA0001 E, ");
	        sql.append(" DATA0008 F, ");
	        sql.append(" DATA0008 G, ");
	        sql.append(" DATA0009 H  ");
	        sql.append(" WHERE ");
	        sql.append(" A.CUSTOMER_PTR = B.RKEY  ");
	        sql.append(" AND A.INVENTORY_PTR = D.RKEY  ");
	        sql.append(" AND A.CURRENCY_PTR = E.RKEY  ");
	        sql.append(" AND B.SALES_REP_PTR = H.RKEY ( + )  ");
	        sql.append(" AND D.PROD_CODE_SELL_PTR = G.RKEY  ");
	        sql.append(" AND ( A.SO_TYPE = 4 OR A.SO_TYPE = 3 )  ");
	        sql.append(" AND A.TTYPE = 3  ");
	        sql.append(" AND A.STATUS = 3  ");
	        sql.append(" AND A.SO_TYPE = 4  ");
	        sql.append(" AND B.DATA0008_PTR_2 = F.RKEY ( + )  ");
	        for(int i=0;i<xhs.length;i++) {
				String XH=xhs[i].toUpperCase();
				if(i==0&&(!"".equals(XH))) {
					sql.append(" AND "+"( D.INV_PART_DESCRIPTION_C LIKE '%"+XH+"%' ");
				}else if(i!=0){
					sql.append(" or D.INV_PART_DESCRIPTION_C LIKE '%"+XH+"%' ");
				}
				if(i==xhs.length-1&&(!"".equals(XH))) {
					sql.append(" ) ");
				}
			}
	        sql.append(" AND A.INVOICE_DATE >= TO_DATE ( '"+startdate+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS' )  ");
	        sql.append(" AND A.INVOICE_DATE <= TO_DATE ( '"+enddate+" 23:59:59', 'YYYY-MM-DD HH24:MI:SS' ) "); 
	        sql.append(" ) A  ");
	        sql.append(" GROUP BY ");
	        sql.append(" PROD_CODE,PROD_NAME, ");
	        sql.append(" TO_CHAR ( IN_DATE, 'YYYY-MM' ) ");
		System.out.println("本月销量sql："+sql);
		return sql.toString();
	}
	
	
	public String getDaySQL(Para para) {
		String[] xhs=para.getXh().trim().split(",");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String day=sdf.format(date);
		StringBuffer sql=new StringBuffer();
		        sql.append(" SELECT ");
		        sql.append(" PROD_CODE,PROD_NAME,TO_CHAR ( IN_DATE, 'YYYY-MM' ),SUM( PARTS_ORDERED ) shuliang ,SUM( AMOUNT )  xiaoliang ");
		        sql.append(" FROM ");
		        sql.append(" ( ");
		        sql.append(" SELECT ");
		        sql.append(" A.IN_DATE, ");
		        sql.append(" ( A.PARTS_ORDERED + A.PARTS_ALLOC ) PARTS_ORDERED, ");
		        sql.append(" E.PROD_CODE, ");
		        sql.append(" E.PROD_NAME, ");
		        sql.append(" ROUND ( A.PART_PRICE * A.PARTS_ORDERED, 2 ) AMOUNT  ");
		        sql.append(" FROM ");
		        sql.append(" DATA0017 B, ");
		        sql.append(" DATA0010 C, ");
		        sql.append(" DATA0008 E, ");
		        sql.append(" DATA0008 F, ");
		        sql.append(" DATA0009 G, ");
		        sql.append(" DATA0001 D, ");
		        sql.append(" DATA0060 A  ");
		        sql.append(" WHERE ");
		        sql.append(" A.CUSTOMER_PTR = C.RKEY  ");
		        sql.append(" AND A.INVENTORY_PTR = B.RKEY  ");
		        sql.append(" AND C.SALES_REP_PTR = G.RKEY ( + )  ");
		        sql.append(" AND A.CURRENCY_PTR = D.RKEY  ");
		        sql.append(" AND C.DATA0008_PTR_2 = E.RKEY ( + )  ");
		        sql.append(" AND B.PROD_CODE_SELL_PTR = F.RKEY  ");
		        sql.append(" AND A.SALES_TYPE = 3  ");
		        sql.append(" AND A.SALES_TYPE > 1  ");
		        sql.append(" AND ( ( A.FOC = 0 ) OR ( A.FOC = 1 ) )  ");
		        sql.append(" AND A.STATUS > 0  ");
		        for(int i=0;i<xhs.length;i++) {
					String XH=xhs[i].toUpperCase();
					if(i==0&&(!"".equals(XH))) {
						sql.append(" AND "+"( B.INV_PART_DESCRIPTION_C LIKE '%"+XH+"%' ");
					}else if(i!=0){
						sql.append(" or B.INV_PART_DESCRIPTION_C LIKE '%"+XH+"%' ");
					}
					if(i==xhs.length-1&&(!"".equals(XH))) {
						sql.append(" ) ");
					}
				}
		        sql.append(" AND A.IN_DATE >= TO_DATE ( '"+day+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS' )  ");
		        sql.append(" AND A.IN_DATE <= TO_DATE ( '"+day+" 23:59:59', 'YYYY-MM-DD HH24:MI:SS' )  ");
		        sql.append(" AND A.STATUS <> 4  ");
		        sql.append(" UNION ALL ");
		        sql.append(" SELECT ");
		        sql.append(" A.IN_DATE, ");
		        sql.append(" ( - A.RMA_QTY ) PARTS_ORDERED, ");
		        sql.append(" F.PROD_CODE, ");
		        sql.append(" F.PROD_NAME,- ROUND ( A.UNIT_PRICE * A.RMA_QTY, 2 ) AMOUNT  ");
		        sql.append(" FROM ");
		        sql.append(" DATA0098 A, ");
		        sql.append(" DATA0010 B, ");
		        sql.append(" DATA0017 D, ");
		        sql.append(" DATA0001 E, ");
		        sql.append(" DATA0008 F, ");
		        sql.append(" DATA0008 G, ");
		        sql.append(" DATA0009 H  ");
		        sql.append(" WHERE ");
		        sql.append(" A.CUSTOMER_PTR = B.RKEY  ");
		        sql.append(" AND A.INVENTORY_PTR = D.RKEY  ");
		        sql.append(" AND A.CURRENCY_PTR = E.RKEY  ");
		        sql.append(" AND B.SALES_REP_PTR = H.RKEY ( + )  ");
		        sql.append(" AND D.PROD_CODE_SELL_PTR = G.RKEY  ");
		        sql.append(" AND ( A.SO_TYPE = 4 OR A.SO_TYPE = 3 )  ");
		        sql.append(" AND A.TTYPE = 3  ");
		        sql.append(" AND A.STATUS = 3  ");
		        sql.append(" AND A.SO_TYPE = 4  ");
		        sql.append(" AND B.DATA0008_PTR_2 = F.RKEY ( + )  ");
		        for(int i=0;i<xhs.length;i++) {
					String XH=xhs[i].toUpperCase();
					if(i==0&&(!"".equals(XH))) {
						sql.append(" AND "+"( D.INV_PART_DESCRIPTION_C LIKE '%"+XH+"%' ");
					}else if(i!=0){
						sql.append(" or D.INV_PART_DESCRIPTION_C LIKE '%"+XH+"%' ");
					}
					if(i==xhs.length-1&&(!"".equals(XH))) {
						sql.append(" ) ");
					}
				}
		        sql.append(" AND A.INVOICE_DATE >= TO_DATE ( '"+day+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS' )  ");
		        sql.append(" AND A.INVOICE_DATE <= TO_DATE ( '"+day+" 23:59:59', 'YYYY-MM-DD HH24:MI:SS' ) "); 
		        sql.append(" ) A  ");
		        sql.append(" GROUP BY ");
		        sql.append(" PROD_CODE,PROD_NAME, ");
		        sql.append(" TO_CHAR ( IN_DATE, 'YYYY-MM' ) ");
		System.out.println("本日销量sql："+sql);
		return sql.toString();
	}
}
