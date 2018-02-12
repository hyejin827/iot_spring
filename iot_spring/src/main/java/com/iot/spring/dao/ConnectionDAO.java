package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionDAO {

	public List<ConnectionInfoVO> selectConnectionList(ConnectionInfoVO ci);
	public ConnectionInfoVO selectConnection(int ciNo);
	public int insertConnection(ConnectionInfoVO ci);
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception ;
	List<TableVO> selectTableList(SqlSession ss, String dbName);
	List<ColumnVO> selectColumnList(String dbName);
}
