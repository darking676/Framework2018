package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bit.model.entity.GuestVo;

public class GuestDao {
	Logger log = Logger.getLogger(this.getClass());
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GuestDao() {
		try {
			getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void getConnection() throws ClassNotFoundException, SQLException{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		Class.forName("oracle.jdbc.OracleDriver");
		conn=DriverManager.getConnection(url, user, password);
	}
	
	public List<GuestVo> selectAll() throws SQLException{
		log.debug("selectAll()");
		List<GuestVo> list = new ArrayList<GuestVo>();
		String sql="SELECT * FROM GUEST";
		try {
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
		} finally {
			close();
		}
		return list;
	}
	
	public void insertOne(GuestVo bean) throws SQLException{
		log.debug(bean);
		String sql="insert into guest values (?,?,sysdate,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		}finally{
			close();
		}
	}
	
	public GuestVo selectOne(int pk) throws SQLException{
		log.debug(pk);
		GuestVo bean = new GuestVo();
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
	
	public int updateOne(GuestVo bean) throws SQLException{
		int result=0;
		String sql="UPDATE GUEST SET NAME=?, PAY=? WHERE SABUN=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			result=pstmt.executeUpdate();
		}finally{
			close();
		}
		return result;
	}
	
	public int deleteOne(int pk) throws SQLException{
		int result=0;
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			result=pstmt.executeUpdate();
		}finally{
			close();
		}
		return result;
	}

	private void close() throws SQLException {
		if(conn!=null)conn.close();
	}
	
}












