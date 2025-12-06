package com.demo.service;

import com.demo.beans.MyUser;

public interface LoginServiceI 
{

	MyUser validateUser(String username, String password);

}
