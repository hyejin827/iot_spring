package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionService {

	public List<ConnectionInfoVO> getConnectionList(ConnectionInfoVO ci);
	public ConnectionInfoVO getConnection(ConnectionInfoVO ci);
	public void insertConnection(Map<String,Object> rMap, ConnectionInfoVO ci);
	public List<Map<String, Object>> getDatabaseList();
	List<TableVO> getTableList(String dbName);
	List<ColumnVO> getColumnList(String dbName);
}