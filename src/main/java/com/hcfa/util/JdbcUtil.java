package com.hcfa.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtil {
	//创建连接池
	private static DataSource dataSource;
	//加载配置文件,创建连接池
	static{
	try {
	InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
	Properties pro = new Properties();
	pro.load(is);
	dataSource = BasicDataSourceFactory.createDataSource(pro);
	}  catch (Exception e) {
	e.printStackTrace();
	}
	}
	//获得连接池
	public static DataSource getDataSource() {
	return dataSource;
	}

	

	public static Connection getConnection() throws SQLException {
	return dataSource.getConnection();
	}

}
