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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iot.spring.service.EmpService;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.Emp;
import com.iot.spring.vo.User;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);

	@Autowired
	private EmpService es;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getEmpList(Model m) {
		List<Emp> empList = es.getEmpList();
		m.addAttribute("empList", empList);
		return "emp/jstl_list";
	}
	
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getEmpListAjax(Model m) {
		List<Emp> empList = es.getEmpList();
		Map<String,Object> returnMap = new HashMap<String, Object>();
		returnMap.put("empList", empList);
		returnMap.put("msg", "성공했셔");
		return returnMap;
	}
	
//	@RequestMapping(value="/insert", method=RequestMethod.GET)
//	public String insertEmp(
//			@RequestParam Map<String,String> map,
//			Model m) {
//		log.info("insert result => {}", es.insertEmp(map));
//		return "emp/write";
//	}
	
//	@RequestMapping(value="/insert", method=RequestMethod.GET)
//	public String insertEmp(
//			@Valid Emp empDTO, Errors es,
//			Model m) {
//		if(es.hasErrors()) {
//			log.info("error => {}", es);
//			List<ObjectError> oeList = es.getAllErrors();
//			m.addAttribute("errorMsg", oeList);
//			return "error/error";
//		}
//		log.info("insert => {}", this.es.insertEmp(empDTO));
//		return "emp/write";
//	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView insertEmp(
			@Valid Emp empDTO, Errors es,
			ModelAndView m) throws Exception {
		log.info("insert result => {}", this.es.insertEmp(empDTO));
		if(es.hasErrors()) {
			log.info("error => {}", es);
			throw new Exception(es.getAllErrors().get(0).getDefaultMessage());
		}
		m.setViewName("emp/write");
		return m;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateEmp(
			@RequestParam Map<String,Object> map,
			Model m) {
		
		log.info("update result => {}", es.updateEmp(map));
		return "emp/jstl_list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteEmp(
			@RequestParam Map<String,Object> map,
			Model m) {
		log.info("delete result => {}", es.deleteEmp(map));
		return getEmpList(m);
	}
}
