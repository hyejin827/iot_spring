package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserInfoDAO;
import com.iot.spring.service.UserInfoService;
import com.iot.spring.vo.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO uidao;
	
	@Override
	public List<UserInfo> getUserInfoList(UserInfo ui) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getUserInfo(UserInfo ui) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUserInfo(Map<String, Object> map, UserInfo ui) {
		int result = uidao.insertUserInfo(map, ui);
		if(result==1) {
			map.put("msg", "회원가입 성공!");
		}else {
			map.put("msg", "회원가입 실패!");
		}
	}

	@Override
	public void deleteUserInfo(Map<String, Object> map, UserInfo ui) {
		int result = uidao.deleteUserInfo(map, ui);
		if(result==1) {
			map.put("msg", "삭제 성공!");
		}else {
			map.put("msg", "삭제 실패!");
		}
	}

}
