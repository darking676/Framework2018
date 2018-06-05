package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.model.GuestDao;
import com.bit.utils.MyController;

public class DetailController implements MyController {

	@Override
	public String execute(HttpServletRequest req) {
		String idx=req.getParameter("idx");
		int pk=Integer.parseInt(idx);
		try{
			GuestDao dao = new GuestDao();
			req.setAttribute("bean", dao.selectOne(pk));
		}catch(Exception ex){}
		return "detail";
	}

}
