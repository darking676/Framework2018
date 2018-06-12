package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.model.entity.GuestVo;
import com.sun.org.apache.bcel.internal.generic.RET;

public class GuestDao {
	
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="scott";
	private String password="tiger";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public GuestDao() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
	}

	public List<GuestVo> queryList(String sql, Object ... objs) throws SQLException{
		List<GuestVo> list = new ArrayList<GuestVo>();
		try{
		pstmt=conn.prepareStatement(sql);
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
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
			this.close();
		}
		return list;
	}

	private void close() throws SQLException {
		if(conn!=null)conn.close();
	}

	public GuestVo selectOne(int idx) throws SQLException {
		String sql="select * from guest where sabun=?";
		return queryList(sql, idx).get(0);
	}
	
	public List<GuestVo> selectAll() throws SQLException{
		String sql="SELECT * FROM GUEST ORDER BY SABUN DESC";
		return queryList(sql);
	}

	public int updateOne(GuestVo bean) throws SQLException {
		String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		return queryUpdate(sql,bean.getName(),bean.getPay(),bean.getSabun());
	}
	
	public void insertOne(GuestVo bean) throws SQLException{
		String sql="INSERT INTO GUEST VALUES (?,?,SYSDATE,?)";
		queryUpdate(sql, bean.getSabun(),bean.getName(),bean.getPay());
	}
	
	public int deleteOne(int pk) throws SQLException{
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		return queryUpdate(sql, pk);
	}

	private int queryUpdate(String sql, Object ...objs) throws SQLException {
		try{
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			return pstmt.executeUpdate();
		}finally{
			close();
		}
	}
}













