package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.utils.MyController;

public class InsertController implements MyController {

	@Override
	public String execute(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return "redirect:list.do";
	}

}
