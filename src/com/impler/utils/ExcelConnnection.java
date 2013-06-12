package com.impler.utils;

/**
 * Excel连接
 * @author Invalid
 *
 */
public class ExcelConnnection extends AbstractOfficeConnection{

	public ExcelConnnection(String file) {
		super(file);
	}

	@Override
	protected String getUrl() {
		return "jdbc:odbc:DRIVER={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ="+getFile()+";READONLY=FALSE";
	}

}
