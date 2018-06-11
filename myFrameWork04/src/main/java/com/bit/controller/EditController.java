package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.model.GuestDao;
import com.bit.utils.BitController;

public class EditController implements BitController {

	@Override
	public String execute(HttpServletRequest req) {
		String param=req.getParameter("idx");
		int pk = Integer.parseInt(param);
		
		GuestDao dao = new GuestDao();
		try {
			req.setAttribute("bean", dao.selectOne(pk));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("view", "Update");
		return "detail";
	}

}
