package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.Emp;

public interface EmpService {

	public List<Emp> getEmpList();
	public Emp getEmp();
	public int insertEmp(Emp empDTO);
	public int updateEmp(Emp empDTO);
	public int deleteEmp(Map<String,String> map);
}
