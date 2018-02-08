package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserInfoDAO;
import com.iot.spring.vo.UserInfo;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public List<UserInfo> selectUserInfoList() {
		SqlSession ss = ssf.openSession();
		List<UserInfo> userInfoList = ss.selectList("user_info.selectUserList");
		ss.close();
		return userInfoList;
	}

	@Override
	public UserInfo selectUserInfo(UserInfo ui) {
		SqlSession ss = ssf.openSession();
		UserInfo uif = ss.selectOne("user_info.selectUser", ui);
		ss.close();
		return uif;
	}

	@Override
	public int insertUserInfo(Map<String, Object> map, UserInfo ui) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("user_info.insertUser", ui);
		return result;
	}

	@Override
	public int deleteUserInfo(Map<String, Object> map, UserInfo ui) {
		SqlSession ss= ssf.openSession();
		int result = ss.delete("user_info.deleteUser", ui);
		ss.close();
		return result;
	}

	@Override
	public int updateUserInfo(Map<String, Object> map, UserInfo ui) {
		SqlSession ss = ssf.openSession();
		int result = ss.update("user_info.updateUser", ui);
		ss.close();
		return result;
	}
}
