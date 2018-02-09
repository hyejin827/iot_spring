package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;

public interface UserDAO {

	List<UserInfo> selectUserInfoList(UserInfo ui);
	public UserInfo selectUserInfo(UserInfo ui);
	int insertUser(UserInfo ui);
	int checkUserInfo(UserInfo ui);
}
