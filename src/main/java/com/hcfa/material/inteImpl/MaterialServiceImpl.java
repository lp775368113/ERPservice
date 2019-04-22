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
		String prodSupper=(String) cs.get("prodSupper");
		String custPartCode=(String) cs.get("custPartCode");
		try {
			if(!"".equals(prodSupper)&&prodSupper!=null) {
				prodSupper =CodeUtil.getLM(prodSupper);
				cs.put("prodSupper", prodSupper);
			}
			if(!"".equals(custPartCode)&&custPartCode!=null) {
				custPartCode =CodeUtil.getLM(custPartCode);
				cs.put("custPartCode", custPartCode);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		logger.info("请求参数："+cs.toString());
		List<Data0017> list=data0017Mapper.getPage(cs);
		Integer count=data0017Mapper.getPageCount(cs);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		JSONObject json = JSONObject.fromObject(result);
		logger.info("返回值："+json.toString());
		return json.toString();
	}

	@Override
	public String getDWInfo(String para2) {
		JSONObject jsonstr = JSONObject.fromObject(para2);
		HashMap cs=(HashMap) JSONObject.toBean(jsonstr, Map.class);
		logger.info(cs.toString());
		List<Units> units=unitsMapper.getUnits();
		JSONObject json = JSONObject.fromObject(units);
		logger.info(json.toString());
		return json.toString();
	}
	
}
