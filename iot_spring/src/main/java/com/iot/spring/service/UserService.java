package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;

public interface UserService {

	List<UserInfo> getUserInfoList(UserInfo ui);
	UserInfo getUserInfo(UserInfo ui);
	void insertUser(Map<String,Object> rMap, UserInfo ui);
}
