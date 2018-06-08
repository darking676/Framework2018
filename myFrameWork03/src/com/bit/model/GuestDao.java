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

public abstract class GuestDao {
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
		String sql="SELECT * FROM GUEST ORDER BY SABUN DESC";
		return executeQuery(sql);
	}
	
	public GuestVo selectOne(int pk) throws SQLException{
		String sql="SELECT * FROM GUEST WHERE SABUN=?";
		return (GuestVo) executeObject(sql,new Object[]{pk});
	}
	
	public void insertOne(GuestVo bean) throws Exception{
		String sql="INSERT INTO GUEST VALUES (?,?,SYSDATE,?)";
		executeUpdate(sql,new Object[]{bean.getSabun(),bean.getName(),bean.getPay()});
	}
	
	public int updateOne(GuestVo bean) throws Exception{
		String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		Object[] objs={bean.getName(),bean.getPay(),bean.getSabun()};
		return executeUpdate(sql,objs);
	}
	
	public int deleteOne(int pk) throws Exception{
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		Object[] objs={pk};
		return executeUpdate(sql,objs);
	}
	
	public abstract Object mapper(ResultSet rs) throws SQLException;
//	private Object mapper() throws SQLException{
//		GuestVo bean = new GuestVo(
//				rs.getInt("sabun"), rs.getString("name")
//				, rs.getDate("nalja"), rs.getInt("pay")
//				);
//		return bean;
//	}
	
	private List executeQuery(String sql) throws SQLException{
		return executeQuery(sql,new Object[]{});
		
	}
	private Object executeObject(String sql,Object[] objs) throws SQLException{
		List list = new ArrayList();
		try{
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				Object bean = mapper(rs);
				log.debug(bean);
				list.add(bean);
			}
		} finally {
			connClose();
		}
		log.debug(list.size());
		return list.get(0);
		
	}
	private List executeQuery(String sql,Object[] objs) throws SQLException{
		List list = new ArrayList();
		try{
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				Object bean = mapper(rs);
				log.debug(bean);
				list.add(bean);
			}
		} finally {
			connClose();
		}
		log.debug(list.size());
		return list;
		
	}
	
	private int executeUpdate(String sql, Object[] objs) throws SQLException{
		int result=0;
		try{
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
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

















