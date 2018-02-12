package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.common.dbcon.DBConnector;
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
		List<ConnectionInfoVO> result = null;
		SqlSession ss= ssf.openSession();
		result = ss.selectList("connection_info.selectConnectionInfo", ci);
		ss.close();
		return result;
	}

	@Override
	public ConnectionInfoVO selectConnection(int ciNo) {
		SqlSession ss= ssf.openSession();
		ConnectionInfoVO ci = ss.selectOne("connection_info.selectConnectionInfoWithCiNo", ciNo);
		ss.close();
		return ci;
	}

	@Override
	public int insertConnection(ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("connection_info.insertConnectionInfo", ci);
		ss.close();
		return result;
	}

	@Override
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception {
		return ss.selectList("connection_info.selectDatabase");
	}

	@Override
	public List<TableVO> selectTableList(SqlSession ss, String dbName) {
		List<TableVO> result = null;
		result = ss.selectList("connection_info.selectTable", dbName);
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
