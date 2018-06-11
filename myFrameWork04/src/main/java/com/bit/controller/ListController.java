package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.model.GuestDao;
import com.bit.utils.BitController;

public class ListController implements BitController {

	@Override
	public String execute(HttpServletRequest req) {
		GuestDao dao = new GuestDao();
		try {
			req.setAttribute("alist", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list";
	}

}
