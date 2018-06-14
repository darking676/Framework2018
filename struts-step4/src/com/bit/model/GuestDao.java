package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.model.entity.GuestVo;

public class GuestDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public GuestDao() {
		try {
			getConn();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void getConn() throws ClassNotFoundException, SQLException {
		String driver="org.h2.Driver";
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		
	}
	
	public List<GuestVo> selectAll() throws SQLException{
		List<GuestVo> list = new ArrayList<GuestVo>();
		String sql="SELECT * FROM GUEST ORDER BY SABUN DESC";
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(
						rs.getInt("sabun"),rs.getString("name")
						,rs.getDate("nalja"),rs.getInt("pay")
						));
			}
		}finally{
			close();
		}
		return list;
	}
	
	public GuestVo selectOne(int pk) throws SQLException{
		GuestVo bean =new GuestVo();
		String sql="select * from guest where sabun=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
			}
		}finally{
			close();
		}
		return bean;
	}
	
	public void insertOne(GuestVo bean) throws SQLException{
		String sql="insert into guest values (?,?,sysdate,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		}finally{close();}
	}
	
	public int updateOne(GuestVo bean) throws SQLException{
		String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
		}finally{
			close();
		}
	}
	
	public int deleteOne(int pk) throws SQLException{
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			return pstmt.executeUpdate();
		}finally{
			close();
		}
	}

	private void close() throws SQLException {
		if(conn!=null)conn.close();
	}
}


















