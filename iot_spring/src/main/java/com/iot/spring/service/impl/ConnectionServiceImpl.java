package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;

@Service
public class ConnectionServiceImpl implements ConnectionService{
	
	@Autowired
	private ConnectionDAO condao;

	@Override
	public List<ConnectionInfoVO> getConnectionList(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionInfoVO getConnection(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertConnection(Map<String,Object> rMap, ConnectionInfoVO ci) {
		int result = condao.insertConnection(ci);
		if(result==1) {
			rMap.put("msg", "성공! 룰루랄라"); 
		}else {
			rMap.put("msg", "실패!");
		}
	}
}
