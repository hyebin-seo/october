package com.test.nonspring03;

public class ServiceImpl {
	private DAO dao;
	
	public ServiceImpl() {
		
	}
	
	public ServiceImpl(DAO dao) {
		this.dao = dao;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	public void biz() {
		
	}
	
}
