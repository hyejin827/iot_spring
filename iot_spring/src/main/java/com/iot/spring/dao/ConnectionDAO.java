package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionDAO {

	public List<ConnectionInfoVO> selectConnectionList(ConnectionInfoVO ci);
	public ConnectionInfoVO selectConnection(ConnectionInfoVO ci);
	public int insertConnection(ConnectionInfoVO ci);
	public List<Map<String, Object>> selectDatabaseList();
	List<TableVO> selectTableList(String dbName);
	List<ColumnVO> selectColumnList(String dbName);
}
