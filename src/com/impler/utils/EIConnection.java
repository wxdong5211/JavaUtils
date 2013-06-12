package com.impler.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接
 * @author Invalid
 *
 */
public interface EIConnection {

	/**
	 * 获取连接
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Connection getConnection() throws ClassNotFoundException, SQLException;

}
