package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.utils.BitController;


public class AddController implements BitController {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		
		return "add";
	}
}
