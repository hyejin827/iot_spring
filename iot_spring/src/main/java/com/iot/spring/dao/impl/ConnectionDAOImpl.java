package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Repository
public class ConnectionDAOImpl implements ConnectionDAO {

	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public List<ConnectionInfoVO> selectConnectionList(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionInfoVO selectConnection(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertConnection(ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("connection_info.insertConnectionInfo", ci);
		ss.close();
		return result;
	}

	@Override
	public List<Map<String, Object>> selectDatabaseList() {
		List<Map<String,Object>> result = null;
		SqlSession ss= ssf.openSession();
		result = ss.selectList("connection_info.selectDatabase");
		ss.close();
		return result;
	}

	@Override
	public List<TableVO> selectTableList(String dbName) {
		List<TableVO> result = null;
		final SqlSession ss= ssf.openSession();
		result = ss.selectList("connection_info.selectTable", dbName);
		ss.close();
		return result;
	}

	@Override
	public List<ColumnVO> selectColumnList(String dbName) {
		List<ColumnVO> result = null;
		final SqlSession ss = ssf.openSession();
		result = ss.selectList("connection_info.selectColumn", dbName);
		ss.close();
		return result;
	}
}
