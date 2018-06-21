package com.bit.spring06.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class GuestDaoTest {
	Logger log=Logger.getLogger(getClass());
	
	static GuestDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Resource resource=new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		dao=(GuestDao) factory.getBean("guestDao");
	}

	@Before
	public void setUp() throws Exception {
		log.debug(dao);
	}

	@Test
	public void testSelectAll() throws SQLException {
		assertNotNull(dao.selectAll());
	}

}
