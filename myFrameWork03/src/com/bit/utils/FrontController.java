package com.bit.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.controller.AddController;
import com.bit.controller.ListController;

@WebServlet("*.do")
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
		// url			controller			method	view
		// ---------------------------------------------------
		// /list.do		ListController		get - list.jsp
		// /add.do		AddController		get - add.jsp
		// /insert.do	InsertController	post- list.do
		// /detail.do	DetailController	get - detail.jsp
		// /edit.do		EditController		get - edit.jsp
		// /update.do	UpdateController	post- detail.do
		// /delete.do	DeleteController	post- list.do
		// ---------------------------------------------------
		// view String view.jsp
		// redirect String redirect:re.do
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("/list.do", "com.bit.controller.ListController");
		map.put("/add.do", "com.bit.controller.AddController");
		map.put("/insert.do", "com.bit.controller.InsertController");
		map.put("/detail.do", "com.bit.controller.DetailController");
		map.put("/edit.do", "com.bit.controller.EditController");
		map.put("/update.do", "com.bit.controller.UpdateController");
		map.put("/delete.do", "com.bit.controller.DeleteController");
		
		String uri=req.getRequestURI();
		uri=uri.substring(req.getContextPath().length());
		BitController controller=null;
		String className="err.do";
	
		Set<String> keys = map.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()){
			String key=ite.next();
			if(uri.equals(key)){
				className=map.get(key);
			}
		}
		
//		if(uri.equals("/list.do")){
//			className="com.bit.controller.ListController";
//		}
//		if(uri.equals("/add.do")){
//			className="com.bit.controller.AddController";
//		}
//		if(uri.equals("/insert.do")){
//			className="com.bit.controller.InsertController";
//		}
//		if(uri.equals("/detail.do")){
//			className="com.bit.controller.DetailController";
//		}
//		if(uri.equals("/edit.do")){
//			className="com.bit.controller.EditController";
//		}
//		if(uri.equals("/update.do")){
//			className="com.bit.controller.UpdateController";
//		}
//		if(uri.equals("/delete.do")){
//			className="com.bit.controller.DeleteController";
//		}
		try {
			Class<?> clzz = Class.forName(className);
			controller=(BitController) clzz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String view=null;
		String prifix="/WEB-INF/view/";
		String suffix=".jsp";
		try {
			view=controller.execute(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(view.startsWith("redirect:")){
			view=view.substring("redirect:".length());
			resp.sendRedirect(view);
		}else{
			req.getRequestDispatcher(prifix+view+suffix).forward(req, resp);
		}
	}
}































