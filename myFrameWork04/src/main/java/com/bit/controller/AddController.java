package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.utils.BitController;

public class AddController implements BitController {

	@Override
	public String execute(HttpServletRequest req) {
		return "add";
	}

}
