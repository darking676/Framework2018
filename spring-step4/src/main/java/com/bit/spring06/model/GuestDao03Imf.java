package com.bit.spring06.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.spring06.model.entity.GuestVo;

public class GuestDao03Imf implements GuestDao {
	Logger log=Logger.getLogger(getClass());
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="SELECT * FROM GUEST ORDER BY SABUN";
		return template.query(sql, new RowMapper<GuestVo>(){
			@Override
			public GuestVo mapRow(ResultSet rs, int cnt) throws SQLException {
				log.debug(cnt);
				GuestVo bean = new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				return bean;
			}
		});
	}

	@Override
	public GuestVo selectOne(int pk) throws SQLException {
		String sql="SELECT * FROM GUEST WHERE SABUN=?";
		Object[] params=new Object[]{pk};
		return template.queryForObject(sql,params, new RowMapper<GuestVo>(){
			@Override
			public GuestVo mapRow(ResultSet rs, int cnt) throws SQLException {
				log.debug(cnt);
				GuestVo bean = new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				return bean;
			}
		});
	}

	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		String sql="INSERT INTO GUEST (NAME,NALJA,PAY) VALUES (?,NOW(),?)";
		Object[] params={bean.getName(),bean.getPay()};
		return template.update(sql, params);
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		Object[] params={bean.getName(),bean.getPay(),bean.getSabun()};
		return template.update(sql, params);
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		Object[] params={pk};
		return template.update(sql,params);
	}

}
