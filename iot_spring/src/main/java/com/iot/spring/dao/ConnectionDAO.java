package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.ConnectionInfoVO;

public interface ConnectionDAO {

	public List<ConnectionInfoVO> selectConnectionList(ConnectionInfoVO ci);
	public ConnectionInfoVO selectConnection(ConnectionInfoVO ci);
	public int insertConnection(ConnectionInfoVO ci);
}
