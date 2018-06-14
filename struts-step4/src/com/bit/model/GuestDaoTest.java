package com.bit.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.bit.model.entity.GuestVo;

public class GuestDaoTest {

	private GuestDao dao;

	@Before
	public void setUp() throws Exception {
		dao = new GuestDao();
	}
	
	@Test
	public void testSelectAll() throws SQLException{
		assertEquals(5, dao.selectAll().size());
	}
}










