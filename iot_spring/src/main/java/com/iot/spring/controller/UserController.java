package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iot.spring.service.EmpService;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.Emp;
import com.iot.spring.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService us;
	
	@RequestMapping(value="/listb", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getUserListAjax(Model m) {
		List<User> userList = us.getUserList();
		Map<String,Object> returnUserMap = new HashMap<String, Object>();
		returnUserMap.put("userList", userList);
		returnUserMap.put("msg", "성공했셔"); 
		return returnUserMap;
	}
}
