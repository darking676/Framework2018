package com.bit.spring06.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.spring06.model.entity.GuestVo;

public class GuestDao02Imf implements GuestDao{
	Logger log = Logger.getLogger(getClass());
	
	private JdbcTemplate template = new JdbcTemplate();
	
	public GuestDao02Imf(DataSource dataSource) {
		template.setDataSource(dataSource);
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="SELECT * FROM GUEST ORDER BY SABUN DESC";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
