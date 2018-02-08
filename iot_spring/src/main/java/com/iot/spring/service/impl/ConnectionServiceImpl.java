package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

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

	@Override
	public List<Map<String, Object>> getDatabaseList() {
		List<Map<String,Object>> dbList = condao.selectDatabaseList();
		int idx = 0;
		for(Map<String,Object> mDb : dbList) {
			mDb.put("id", ++idx);
			mDb.put("text", mDb.get("Database"));
			mDb.put("items", new Object[] {});
		}
		return dbList;
	}

	@Override
	public List<TableVO> getTableList(String dbName) {
		return condao.selectTableList(dbName);
	}

	@Override
	public List<ColumnVO> getColumnList(String dbName) {
		return condao.selectColumnList(dbName);
	}
}
