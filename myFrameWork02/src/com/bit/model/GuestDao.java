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
	private final String DRIVER="oracle.jdbc.OracleDriver";
	// crud
	private final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER="scott";
	private final String PASSWORD="tiger";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GuestDao() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public boolean isConnectied() throws SQLException{
		boolean result=conn!=null;
		if(conn!=null)conn.close();
		return result;
	}
	
	// list
	public List<GuestVo> selectAll() throws SQLException{
		List<GuestVo> list = new ArrayList<GuestVo>();
		String sql="SELECT * FROM GUEST ORDER BY SABUN DESC";
		try{
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
		}finally{
			if(conn!=null)conn.close();
		}
		return list;
	}
	// add
	public void insertOne(GuestVo bean) throws SQLException{
		String sql="INSERT INTO GUEST VALUES (?,?,SYSDATE,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		}finally{
			if(conn!=null)conn.close();
		}
	}
	// detail
	public GuestVo selectOne(int pk) throws SQLException{
		String sql="SELECT * FROM GUEST WHERE SABUN=?";
		GuestVo bean = new GuestVo();
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
			if(conn!=null)conn.close();
		}
		return bean;
	}
	// update
	public int updateOne(GuestVo bean) throws SQLException{
		int result=0;
		String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			result=pstmt.executeUpdate();
		}finally{
			if(conn!=null)conn.close();
		}
		return result;
	}
	// delete 
	public int deleteOne(int pk) throws SQLException{
		int result=0;
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			result=pstmt.executeUpdate();
		}finally{
			if(conn!=null)conn.close();
		}
		return result; 
	}
	
}













