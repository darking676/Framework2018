package com.bit.spring06.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.spring06.model.entity.GuestVo;

public class GuestDao01Imf implements GuestDao {
	private DataSource dataSource;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="SELECT * FROM GUEST ORDER BY SABUN";
		List<GuestVo> list= new ArrayList<GuestVo>();
		try(Connection conn=dataSource.getConnection()){
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						));
			}
		}
		return list;
	}

	@Override
	public GuestVo selectOne(int pk) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
