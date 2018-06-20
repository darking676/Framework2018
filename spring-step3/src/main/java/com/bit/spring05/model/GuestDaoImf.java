package com.bit.spring05.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.spring05.model.entity.GuestVo;

public class GuestDaoImf implements GuestDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public List<GuestVo> selectAll() throws SQLException{
		String sql="SELECT * FROM GUEST ORDER BY SABUN DESC";
		List<GuestVo> list=new ArrayList<GuestVo>();
		try(Connection conn=ds.getConnection()){
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(
						rs.getInt(1),
						rs.getString(2),
						rs.getDate(3),
						rs.getInt(4)
						));
			}
		}
		return list;
	}

	public GuestVo selectOne(int pk) throws SQLException{
		String sql="SELECT * FROM GUEST WHERE SABUN=?";
		try(Connection conn=ds.getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			rs=pstmt.executeQuery();
			if(rs.next()) return new GuestVo(
					rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4)
					);
		}
		return null;
	}
	
	public void insertOne(GuestVo bean) throws SQLException{
		String sql="INSERT INTO GUEST (NAME,NALJA,PAY) VALUES (?,NOW(),?)";
		try(Connection conn=ds.getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.executeUpdate();
		}
	}

	public int updateOne(GuestVo command) throws SQLException {
		String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		try(Connection conn=ds.getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, command.getName());
			pstmt.setInt(2, command.getPay());
			pstmt.setInt(3, command.getSabun());
			return pstmt.executeUpdate();
		}
	}
	
	public int deleteOne(int pk) throws SQLException{
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		try(Connection conn=ds.getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			return pstmt.executeUpdate();
		}
	}
}
















