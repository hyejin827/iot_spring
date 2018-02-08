package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;

public interface UserInfoDAO {

	public List<UserInfo> selectUserInfoList();
	public UserInfo selectUserInfo(UserInfo ui);
	public int insertUserInfo(Map<String, Object> map, UserInfo ui);
	public int deleteUserInfo(Map<String, Object> map, UserInfo ui);
	public int updateUserInfo(Map<String, Object> map, UserInfo ui);
}
