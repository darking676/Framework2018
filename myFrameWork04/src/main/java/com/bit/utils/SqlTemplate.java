package com.bit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlTemplate {

	private PreparedStatement pstmt;
	private Connection conn;
	private ResultSet rs;
	
	public SqlTemplate() {
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
	
//	public abstract T mapper(ResultSet rs) throws SQLException;
	
	public List queryList(String sql,RowMapper mapper) throws SQLException{
		return queryList(sql,mapper,new Object[]{});
	}
	
	public List queryList(String sql,RowMapper mapper,Object[] objs) throws SQLException{
		List list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(mapper.mapRow(rs));
			}
		} finally {
			close();
		}
		return list;
	}
	
	public Object queryOne(String sql,RowMapper mapper,Object[] objs) throws SQLException{
		return queryList(sql,mapper,objs).get(0);
	}

	public int queryUpdate(String sql, Object[] objs) throws SQLException{
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
	
	private void close() throws SQLException {
		if(conn!=null)conn.close();
	}
}
