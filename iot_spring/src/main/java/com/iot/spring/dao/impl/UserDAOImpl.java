package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.Emp;
import com.iot.spring.vo.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public List<User> selectUserList() {
		SqlSession ss = ssf.openSession();
		List<User> userList = ss.selectList("user.selectUser");
		ss.close();
		return userList;
	}

}
