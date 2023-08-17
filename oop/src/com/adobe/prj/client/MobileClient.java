package com.adobe.prj.client;

import com.adobe.prj.dao.MobileDao;
import com.adobe.prj.dao.MobileDaoFactory;
import com.adobe.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args) {
//		MobileDao mobileDao = new MobileDaoMongoImpl();
		MobileDao mobileDao = MobileDaoFactory.getMobileDao();
		Mobile m = new Mobile(42,"iPhone 14", 98000.00, "5G");
		mobileDao.addMobile(m); // polymorphic
	}
}

