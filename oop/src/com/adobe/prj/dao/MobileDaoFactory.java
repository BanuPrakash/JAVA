package com.adobe.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
	private static String DAO = "";
	
	// gets called when class is loaded onto Metaspace by classloader
	static {
		// SAXParser or DOMParser to read XML
		ResourceBundle res = ResourceBundle.getBundle("config");
		DAO = res.getString("MOBILE_DAO");
	}
	// factory method
	public static MobileDao getMobileDao() {

		try {
			Class<?> clazz = Class.forName(DAO); // explicitly loading of classes into JVM 
			return (MobileDao) clazz.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
//		return new MobileDaoMongoImpl();
//		return new MobileDaoDbImpl();
	}
}
