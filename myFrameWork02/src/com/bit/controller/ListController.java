package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.model.GuestDao;
import com.bit.utils.MyController;

public class ListController implements MyController {

	@Override
	public String execute(HttpServletRequest req) {
		GuestDao dao;
		try {
			dao = new GuestDao();
			req.setAttribute("alist", dao.selectAll());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list";
	}

}
