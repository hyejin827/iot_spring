package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.User;

public interface UserDAO {

	public List<User> selectUserList();
}
