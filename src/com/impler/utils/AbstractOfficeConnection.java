package com.impler.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * office连接
 * @author Invalid
 *
 */
public abstract class AbstractOfficeConnection implements EIConnection{
	
	private String file;
	
	public AbstractOfficeConnection(String file) {
		this.file = file;
	}

	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		return DriverManager.getConnection(getUrl());
	}
	
	/**
	 * 连接字符串
	 * @return
	 */
	protected abstract String getUrl();

	public String getFile() {
		return file;
	}

}
