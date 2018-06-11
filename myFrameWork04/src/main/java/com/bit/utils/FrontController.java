package com.bit.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// list.do			ListController 		list
		// add.do			AddController		add
		
		
		// Controller
		Map<String, String> map = new HashMap<String, String>();
//		map.put("/list.do", "com.bit.controller.ListController");
//		map.put("/add.do", "com.bit.controller.AddController");
//		map.put("/insert.do", "com.bit.controller.InsertController");
		
		Enumeration<String> paramNames = this.getInitParameterNames();
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement();
			String paramValue=this.getInitParameter(param);
			map.put(param, paramValue);
		}
		
		String uri=req.getRequestURI();
		String root=req.getContextPath();
		uri=uri.substring(root.length());
		String controllerName =null;
		BitController controller=null;
		
		Set<String> keys = map.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()){
			String key = ite.next();
			if(key.equals(uri)){
				controllerName = map.get(key);
			}
		}
		
		try {
			Class<?> clzz = Class.forName(controllerName);
			controller=(BitController)clzz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String path=controller.execute(req);
		// /WEB-INF/view/이름.jsp
		
		// view
		
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


























