package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bit.model.entity.GuestVo;
import com.bit.utils.RowMapper;
import com.bit.utils.SqlTemplate;

public class GuestDao {
	Logger log = Logger.getLogger(this.getClass());
	RowMapper mapper=new RowMapper() {
		
		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			GuestVo bean =new GuestVo(
					rs.getInt("sabun")
					,rs.getString("name")
					,rs.getDate("nalja")
					,rs.getInt("pay")
					);
			return bean;
		}
	};
	
	public GuestDao() {
	}
	
	public List<GuestVo> selectAll() throws SQLException{
		String sql="SELECT * FROM GUEST";
		SqlTemplate template=new SqlTemplate();
		return template.queryList(sql,mapper);
	}
	
	
	public GuestVo selectOne(int pk) throws SQLException{
		String sql="select * from guest where sabun=?";
		SqlTemplate template=new SqlTemplate();
		return (GuestVo) template.queryOne(sql,mapper, new Object[]{pk});
	}
	
	
	public void insertOne(GuestVo bean) throws SQLException{
		String sql="insert into guest values (?,?,sysdate,?)";
		SqlTemplate template=new SqlTemplate();
		Object[] objs={bean.getSabun(),bean.getName(),bean.getPay()};
		template.queryUpdate(sql, objs);
	}
	
	public int updateOne(GuestVo bean) throws SQLException{
		String sql="UPDATE GUEST SET NAME=?, PAY=? WHERE SABUN=?";
		SqlTemplate template=new SqlTemplate();

		Object[] objs={bean.getName(),bean.getPay(),bean.getSabun()};
		int result=template.queryUpdate(sql,objs);
		return result;
	}
	
	public int deleteOne(int pk) throws SQLException{
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		SqlTemplate template=new SqlTemplate();

		Object[] objs={pk};
		int result=template.queryUpdate(sql, objs);
		return result;
	}
	
}












