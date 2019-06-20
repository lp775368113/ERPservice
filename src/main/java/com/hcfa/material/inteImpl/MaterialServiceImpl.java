package com.hcfa.material.inteImpl;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.hcfa.inte.CommonService;
import com.hcfa.material.dao.Data0017Mapper;
import com.hcfa.material.dao.UnitsMapper;
import com.hcfa.material.inte.MaterialService;
import com.hcfa.material.vo.Data0017;
import com.hcfa.material.vo.Units;
import com.hcfa.util.CodeUtil;
import com.hcfa.util.JdbcUtil;
import com.hcfa.vo.Para;
import com.hcfa.vo.Vo;

import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
 
/**接口实现
 * @作者 Administrator
 * @创建日期 2018/6/23 0023
 * @创建时间 11:26.
 */
@WebService(serviceName = "MaterialService",//与前面接口一致
        targetNamespace = "http://www.inte.material.hcfa.com",  //与前面接口一致
        endpointInterface = "com.hcfa.material.inte.MaterialService")  //接口地址
@Component
public class MaterialServiceImpl implements MaterialService {
	
	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);
	
	@Resource
	Data0017Mapper data0017Mapper;
	
	@Resource
	UnitsMapper unitsMapper;

	@Override
	public String getWLInfo(String para1) {
		JSONObject jsonstr = JSONObject.fromObject(para1);
		HashMap cs=(HashMap) JSONObject.toBean(jsonstr, Map.class);
		String rkeys=(String) cs.get("rkeys");
		logger.info("请求参数："+cs.toString());
		List<Map<String, String>> map=data0017Mapper.getCC(cs);
	    Map<String, String> baseMap = new HashMap<String, String>();
		for (Map<String, String> mm : map) {
		        String rkey = null;
		        String warehouse = null;
		        for (Map.Entry<String,String>  entry:mm.entrySet()) {
		            if ("RKEY".equals(entry.getKey())) {
		            	rkey =  String.valueOf(entry.getValue());
		            }else if ("WAREHOUSE".equals(entry.getKey())) {
		            	warehouse =String.valueOf(entry.getValue());
		            }
		        }
		        baseMap.put(rkey,warehouse);
		}
		JSONObject json = JSONObject.fromObject(baseMap);
		logger.info("返回值："+json.toString());
		return json.toString();
	}

	@Override
	public String getDWInfo(String para2) {
		JSONObject jsonstr = JSONObject.fromObject(para2);
		HashMap cs=(HashMap) JSONObject.toBean(jsonstr, Map.class);
		String  custPartCode=(String)cs.get("custPartCode");
		String invPartDescriptionC=(String)cs.get("invPartDescriptionC");
		try {
			if(!"".equals(invPartDescriptionC)&&invPartDescriptionC!=null) {
				invPartDescriptionC =CodeUtil.getLM(invPartDescriptionC);
				cs.put("invPartDescriptionC", invPartDescriptionC);
			}
			if(!"".equals(custPartCode)&&custPartCode!=null) {
				custPartCode =CodeUtil.getLM(custPartCode);
				cs.put("custPartCode", custPartCode);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		Integer cpc=data0017Mapper.countCustPartCode(cs);
		Integer ipdc=data0017Mapper.countInvPartDescriptionC(cs);
		Map<String,Object> result=new HashMap<String,Object>();
		
		result.put("countCustPartCode", (cpc==0)?true:false);
		result.put("conutInvPartDescriptionC", (ipdc==0)?true:false);
		JSONObject json = JSONObject.fromObject(result);
		logger.info("返回值："+json.toString());
		return json.toString();
	}
	
}
