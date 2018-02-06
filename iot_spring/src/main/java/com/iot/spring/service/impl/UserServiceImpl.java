package com.iot.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO udao;

	@Override
	public List<User> getUserList() {
		return udao.selectUserList();
	}

}
