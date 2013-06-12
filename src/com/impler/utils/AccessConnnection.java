package com.impler.utils;


/**
 * Access连接
 * @author Invalid
 *
 */
public class AccessConnnection extends AbstractOfficeConnection{
	
	public AccessConnnection(String file) {
		super(file);
	}

	@Override
	protected String getUrl() {
		return "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+getFile()+";READONLY=FALSE";
	}

}
