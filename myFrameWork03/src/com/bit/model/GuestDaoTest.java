package com.bit.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bit.model.entity.GuestVo;

public class GuestDaoTest {
	GuestDao dao;

	@Before
	public void setUp() throws Exception {
		dao=new GuestDao(false);
	}

	@Test
	public void testSelectAll() throws SQLException {
		List<GuestVo> list = dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
	}
	
	@Test
	public void testSelectOne() throws Exception{
		int sabun=1;
		assertEquals(sabun, dao.selectOne(sabun).getSabun());
	}
	
	@Test
	public void testInsertOne() throws Exception{
		GuestVo target = new GuestVo(9999, "test", null, 9000);
		dao.insertOne(target);
	}
	
	@Test
	public void testUpdateOne() throws Exception{
		GuestVo target = new GuestVo(1, "test", null, 11);
		assertEquals(1, dao.updateOne(target));
	}
	
	@Test
	public void testDeleteOne() throws Exception{
		int sabun=1;
		assertEquals(1, dao.deleteOne(sabun));
		
	}

}










