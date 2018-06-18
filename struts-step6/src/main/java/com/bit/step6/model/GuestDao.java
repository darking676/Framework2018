package com.bit.step6.model;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.bit.step6.model.entity.GuestVo;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class GuestDao {
	private SqlMapClient smc;
	
	public GuestDao() throws IOException {
		String path="SqlMapConfig.xml";
		Reader reader=Resources.getResourceAsReader(path);
		smc=SqlMapClientBuilder.buildSqlMapClient(reader);
	}

	public List<GuestVo> selectAll() throws SQLException {
		return (List<GuestVo>)smc.queryForList("selectAll");
	}

	public GuestVo selectOne(int sabun) throws SQLException {
		return (GuestVo) smc.queryForObject("selectOne",sabun);
	}

	public void insertOne(GuestVo bean) throws SQLException {
		int su=smc.update("insertOne",bean);
		System.out.println("입력:"+su);
	}

	public int updateOne(GuestVo bean) throws SQLException {
		return smc.update("updateOne",bean);
	}
	
	public int deleteOne(int pk) throws SQLException{
		return smc.delete("deleteOne",pk);
	}

	public int selectCnt(GuestVo bean) throws SQLException {
		// select -> int
		return (java.lang.Integer) smc.queryForObject("login",bean);
	}

}









