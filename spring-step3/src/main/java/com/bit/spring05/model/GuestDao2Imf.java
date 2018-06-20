package com.bit.spring05.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.spring05.model.entity.GuestVo;

public class GuestDao2Imf implements GuestDao {
	JdbcTemplate template = new JdbcTemplate();
	RowMapper rowMapper=new RowMapper(){

		@Override
		public Object mapRow(ResultSet rs, int cnt) throws SQLException {
			GuestVo bean=new GuestVo();
			bean.setSabun(rs.getInt("sabun"));
			bean.setName(rs.getString("name"));
			bean.setNalja(rs.getDate("nalja"));
			bean.setPay(rs.getInt("pay"));
			return bean;
		}
		
	};
	
	public GuestDao2Imf(DataSource dataSource) {
		template.setDataSource(dataSource);
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="SELECT * FROM GUEST ORDER BY SABUN";
		return template.query(sql, rowMapper);
		
	}

	@Override
	public GuestVo selectOne(int pk) throws SQLException {
		String sql="SELECT * FROM GUEST WHERE SABUN=?";
		return template.queryForObject(sql, new Object[]{pk}, rowMapper);
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		String sql="INSERT INTO GUEST (NAME,NALJA,PAY) VALUES (?,NOW(),?)";
		template.update(sql, new Object[]{bean.getName(),bean.getPay()});
	}

	@Override
	public int updateOne(GuestVo command) throws SQLException {
		String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		return template.update(sql, new Object[]{command.getName(),command.getPay(),command.getSabun()});
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		return template.update(sql, new Object[]{pk});
	}

}
