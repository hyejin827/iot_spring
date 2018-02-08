package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;

public interface UserInfoService {

	public List<UserInfo> getUserInfoList(UserInfo ui);
	public UserInfo getUserInfo(UserInfo ui);
	public void insertUserInfo(Map<String, Object> map, UserInfo ui);
	public void deleteUserInfo(Map<String, Object> map, UserInfo ui);
}
