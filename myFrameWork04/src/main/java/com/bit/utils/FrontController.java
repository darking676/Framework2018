package com.bit.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		super.init();
		Properties prop = new Properties();
		InputStream ras = getClass().getClassLoader().getResourceAsStream("bit.properties");
		
		try {
			prop.load(ras);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Set<Object> keys = prop.keySet();
		Iterator<Object> ite = keys.iterator();
		while(ite.hasNext()){
			String key=(String) ite.next();
			String value = prop.getProperty(key);
			HendlerMapping.setMap(key, value);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uri=req.getRequestURI();
		String root=req.getContextPath();
		uri=uri.substring(root.length());
		
		BitController controller=HendlerMapping.getMap(uri);
		
		String path=controller.execute(req);
		
		String prefix="/WEB-INF/view/";
		String suffix=".jsp";
		String redirect="redirect:";
		
		if(path.startsWith(redirect)){
			resp.sendRedirect(path.substring(redirect.length()));
		}else{
			req.getRequestDispatcher(prefix+path+suffix).forward(req, resp);
		}
	}
}


























