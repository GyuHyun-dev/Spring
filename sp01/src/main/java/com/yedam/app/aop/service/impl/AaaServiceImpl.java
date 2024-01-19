package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{

	@Autowired
	AaaMapper aaaMapper;
	
	// 어노테이션 service 밑에서만 동작함 db 쪽이라고 mapper 에서 찾으면 x
	@Transactional 
	public void insert() {
		aaaMapper.insertAaa("101");
		aaaMapper.insertAaa("a101");
	}
}
