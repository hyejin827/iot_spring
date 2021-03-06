package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserInfoService;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserInfo;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);

	private ObjectMapper om = new ObjectMapper();

	@Autowired
	private UserInfoService uis;

	@Autowired
	private UserService us;

//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public @ResponseBody Map getUserInfoList(Model m) {
//		List<UserInfo> userInfoList = uis.getUserInfoList();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("userInfoList", userInfoList);
//		return map;
//	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(@Valid UserInfo ui, HttpSession hs) {
		Map<String, Object> map = new HashMap<String, Object>();
		ui = us.getUserInfo(ui);
		map.put("loginOk", false);
		map.put("msg", "로그인 실패");
		if (ui != null) {
			hs.setAttribute("user", ui);
			hs.setAttribute("isLogin", true);
			map.put("msg", "로그인 성공!");
			map.put("loginOk", true);
		}
		return map;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> signup(@Valid UserInfo ui, HttpSession hs) {
		Map<String, Object> map = new HashMap<String, Object>();
		us.insertUser(map, ui);
		return map;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<UserInfo> getUserList(UserInfo ui) {
		return us.getUserInfoList(ui);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteUserInfo(@RequestParam Map<String, Object> map) {
		UserInfo ui = om.convertValue(map, UserInfo.class);
		log.info("UserInfo => {}", ui);
		uis.deleteUserInfo(map, ui);
		return map;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateUserInfo(@RequestParam Map<String, Object> map) {
		UserInfo ui = om.convertValue(map, UserInfo.class);
		log.info("UserInfo => {}", ui);
		uis.updateUserInfo(map, ui);
		return map;
	}
}
