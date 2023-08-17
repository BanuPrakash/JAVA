package com.adobe.prj.dao;

import com.adobe.prj.entity.Mobile;

public class MobileDaoMongoImpl implements MobileDao {

	@Override
	public void addMobile(Mobile m) {
		// db.employees.insert({});
		System.out.println("Mongo Store of " + m.getName());
	}

}
