package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.UserInfo;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public UserInfo selectUserInfo(UserInfo ui) {
		SqlSession ss = ssf.openSession();
		UserInfo rUi = ss.selectOne("user_info.selectUser", ui);
		ss.close();
		return rUi;
	}

	@Override
	public int insertUser(UserInfo ui) {
		SqlSession ss = ssf.openSession();
		int rUi = ss.insert("user_info.insertUser", ui);
		ss.close();
		return rUi;
	}

	@Override
	public int checkUserInfo(UserInfo ui) {
		SqlSession ss = ssf.openSession();
		int result = ss.selectOne("user_info.checkUser", ui);
		ss.close();
		return result;
	}

	@Override
	public List<UserInfo> selectUserInfoList(UserInfo ui) {
		SqlSession ss = ssf.openSession();
		List<UserInfo> result = ss.selectList("user_info.selectUser", ui);
		ss.close();
		return result;
	}
}
