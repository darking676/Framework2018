package com.bit.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.controller.AddController;
import com.bit.controller.DetailController;
import com.bit.controller.InsertController;
import com.bit.controller.ListController;

public class FrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doDo(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doDo(req, resp);
	}
	
	public void doDo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// /list.do
		// /add.do
		// /insert.do
		// /detail.do
		// /edit.do
		// /update.do
		// /delete.do
		String uri=req.getRequestURI();
		uri=uri.substring(req.getContextPath().length());
		// model-controller
		MyController controller=null;
		if("/list.do".equals(uri)){
			controller=new ListController();
		}else if("/detail.do".equals(uri)){
			controller=new DetailController();
		}else if("/add.do".equals(uri)){
			controller=new AddController();
		}else if("/insert.do".equals(uri)){
			controller=new InsertController();
		}
		String viewName=controller.execute(req);
		// view
		// /webapp/WEB-INF/view/
		
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(viewName.substring("redirect:".length()));
			return;
		}
		
		String prifix="/WEB-INF/view/";
		String suffix=".jsp";
		req.getRequestDispatcher(prifix+viewName+suffix).forward(req, resp);
	}
}


















