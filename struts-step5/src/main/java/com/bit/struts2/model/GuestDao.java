package com.bit.struts2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bit.struts2.model.entity.GuestVo;

public class GuestDao {
	Logger log = Logger.getLogger(getClass());
	private PreparedStatement pstmt;
	private ResultSet rs;

	public GuestDao() {
	}
	
	public List<GuestVo> selectAll() throws SQLException{
		List<GuestVo> list=new ArrayList<GuestVo>();
		String sql="SELECT * FROM GUEST";
		try(Connection conn=MyOracle.getConnection()){
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				GuestVo bean =new GuestVo(
						rs.getInt("sabun"),
						rs.getString("name"),
						rs.getDate("nalja"),
						rs.getInt("pay")
						);
				log.debug(bean);
				list.add(bean);
			}
		}
		return list;
	}
	
	public GuestVo selectOne(int pk) throws SQLException{
		GuestVo bean = new GuestVo();
		String sql="SELECT * FROM GUEST WHERE SABUN=?";
		try(Connection conn=MyOracle.getConnection()){
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
		log.debug(bean);
		return bean;
	}
	
	public void insertOne(GuestVo bean) throws SQLException{
		String sql="INSERT INTO GUEST VALUES (?,?,SYSDATE,?)";
		try(Connection conn=MyOracle.getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		}
	}
	
	public int updateOne(GuestVo bean) throws SQLException{
		String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		try(Connection conn=MyOracle.getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
		}
	}
	
	public int deleteOne(int pk) throws SQLException{
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		try(Connection conn=MyOracle.getConnection()){
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pk);
			return pstmt.executeUpdate();
		}
	}
}














