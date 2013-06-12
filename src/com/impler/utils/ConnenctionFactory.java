package com.impler.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接工厂
 * 
 * @author Invalid
 * 
 */
public class ConnenctionFactory {

	/**
	 * 获取连接
	 * @param file
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection(String file) throws ClassNotFoundException,
			SQLException {
		if (file == null || file.length() == 0 || !new File(file).isFile()) {
			return null;
		} else if (file.endsWith("mdb") || file.endsWith(".accdb")) {
			return new AccessConnnection(file).getConnection();
		} else if (file.endsWith("xls") || file.endsWith(".xlsx")
				|| file.endsWith(".xlsm") || file.endsWith(".xlsb")) {
			return new ExcelConnnection(file).getConnection();
		}
		return null;
	}

}
