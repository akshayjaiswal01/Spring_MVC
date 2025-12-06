package com.demo.dao;

import com.demo.beans.MyUser;

public interface LoginDaoI {

	MyUser validateUser(String username, String password);

}
