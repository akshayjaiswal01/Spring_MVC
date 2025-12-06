package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.MyUser;

@Repository
public class LoginDaoImpl implements LoginDaoI 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public MyUser validateUser(String username, String password) 
	{
		try
		{
			MyUser user = jdbcTemplate.queryForObject("select * from user where username=? and password=?",
					new Object [] {username, password}, BeanPropertyRowMapper.newInstance(MyUser.class));
			
			System.out.println(user);
			return user;
		}
		catch(EmptyResultDataAccessException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
