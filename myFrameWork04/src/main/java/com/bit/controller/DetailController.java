package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.model.GuestDao;
import com.bit.utils.BitController;

public class DetailController implements BitController {

	@Override
	public String execute(HttpServletRequest req) {
		GuestDao dao = new GuestDao();
		String param=req.getParameter("idx");
		int pk=Integer.parseInt(param);
		try {
			req.setAttribute("bean", dao.selectOne(pk));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("view", "Detail");
		req.setAttribute("noEdit", "readonly");
		return "detail";
	}

}
