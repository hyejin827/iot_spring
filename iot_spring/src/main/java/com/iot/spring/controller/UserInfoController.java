package com.iot.spring.controller;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserInfoService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.UserInfo;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	
	private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);

	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private UserInfoService uis;
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> insertUserInfo(@RequestParam Map<String,Object> map) {
		UserInfo ui = om.convertValue(map, UserInfo.class);
		log.info("UserInfo => {}", ui);
		uis.insertUserInfo(map, ui);
		return map;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> deleteUserInfo(@RequestParam Map<String,Object> map) {
		UserInfo ui = om.convertValue(map, UserInfo.class);
		log.info("UserInfo => {}", ui);
		uis.deleteUserInfo(map, ui);
		return map;
	}
}
