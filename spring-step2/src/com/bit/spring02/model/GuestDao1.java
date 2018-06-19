package com.bit.spring02.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.spring02.model.entity.GuestVo;

public class GuestDao1 {
	private String className="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://203.236.209.221:3306/mydb?serverTimezone=UTC";
	private String user="scott";
	private String password="tiger";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Connection getConnection() throws SQLException, ClassNotFoundException{
		if(conn==null || conn.isClosed()){
			Class.forName(className);
			conn=DriverManager.getConnection(url, user, password);
		}
		return conn;
	}

	public List<GuestVo> selectAll() throws Exception{
		List<GuestVo> list = new ArrayList<GuestVo>();
		String sql="SELECT * FROM GUEST ORDER BY SABUN";
		try(Connection conn=getConnection()){
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(
						rs.getInt("sabun"),
						rs.getString("name"),
						rs.getDate("nalja"),
						rs.getInt("pay")
						));
			}
		}
		return list;
	}
	
	public void insertOne(GuestVo bean) throws Exception{
		String sql="INSERT INTO GUEST (NAME,NALJA,PAY) VALUES (?,NOW(),?)";
		try(Connection conn=getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.executeUpdate();
		}
	}
	
	public GuestVo selectOne(int pk) throws Exception{
		String sql="SELECT * FROM GUEST WHERE SABUN=?";
		GuestVo bean = new GuestVo();
		try(Connection conn=getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
			}
		}
		return bean;
	}

	public int updateOne(GuestVo bean) throws Exception {
		String sql="UPDATE GUEST SET NAME=?, PAY=? WHERE SABUN=?";
		try(Connection conn=getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
		}
	}
	
	public int deleteOne(int pk) throws Exception{
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		try(Connection conn = getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			return pstmt.executeUpdate();
		}
	}
}








