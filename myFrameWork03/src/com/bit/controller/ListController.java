package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.GuestDao;
import com.bit.utils.BitController;

public class ListController implements BitController{

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		req.setAttribute("alist", new GuestDao().selectAll());
		return "list";
	}
	
}
















