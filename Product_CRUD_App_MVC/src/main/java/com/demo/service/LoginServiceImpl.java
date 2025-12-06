package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.MyUser;
import com.demo.dao.LoginDaoI;

@Service
public class LoginServiceImpl implements LoginServiceI 
{
	@Autowired
	LoginDaoI ldao;
	
	@Override
	public MyUser validateUser(String username, String password) 
	{
		return ldao.validateUser(username, password);
	}

}
