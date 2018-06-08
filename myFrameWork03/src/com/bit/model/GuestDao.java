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
	private Logger log=Logger.getLogger(getClass());
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private boolean auto;
	
	public GuestDao() throws ClassNotFoundException, SQLException {
		getConnection();
	}
	GuestDao(boolean auto) throws ClassNotFoundException, SQLException {
		getConnection();
		AutoCommit(auto);
		this.auto=true;
	}
	
	public void getConnection() throws ClassNotFoundException, SQLException{
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
	}
	
	public void AutoCommit(boolean auto) throws SQLException{
		conn.setAutoCommit(auto);		
	}
	
	public List<GuestVo> selectAll() throws SQLException{
		List<GuestVo> list = new ArrayList<GuestVo>();
		String sql="SELECT * FROM GUEST ORDER BY SABUN DESC";
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				GuestVo bean = new GuestVo(
						rs.getInt("sabun"), rs.getString("name")
						, rs.getDate("nalja"), rs.getInt("pay")
						);
				log.debug(bean);
				list.add(bean);
			}
		} finally {
			connClose();
		}
		log.debug(list.size());
		return list;
	}
	
	public GuestVo selectOne(int pk) throws SQLException{
		GuestVo bean = new GuestVo();
		String sql="SELECT * FROM GUEST WHERE SABUN=?";
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
			connClose();
		}
		log.debug(bean);
		return bean;
	}
	
	public void insertOne(GuestVo bean) throws Exception{
		String sql="INSERT INTO GUEST VALUES (?,?,SYSDATE,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			int result=pstmt.executeUpdate();
			log.debug(result>0);
		}finally{
			connClose();
		}
	}
	
	public int updateOne(GuestVo bean) throws Exception{
		int result=0;
		String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			result=pstmt.executeUpdate();
			log.debug(result>0);
		}finally{
			connClose();
		}
		return result;
	}
	
	public int deleteOne(int pk) throws Exception{
		int result=0;
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			result=pstmt.executeUpdate();
			log.debug(result>0);
		}finally{
			connClose();
		}
		return result;
	}
	public void connClose() throws SQLException{
		if(auto)conn.rollback();
		if(conn!=null)conn.close();		
	}
}

















