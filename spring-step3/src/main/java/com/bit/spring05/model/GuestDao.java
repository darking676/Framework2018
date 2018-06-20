package com.bit.spring05.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.spring05.model.entity.GuestVo;

public interface GuestDao {

	List<GuestVo> selectAll() throws SQLException;
	GuestVo selectOne(int pk) throws SQLException;
	void insertOne(GuestVo bean) throws SQLException;
	int updateOne(GuestVo command) throws SQLException;
	public int deleteOne(int pk) throws SQLException;
}
