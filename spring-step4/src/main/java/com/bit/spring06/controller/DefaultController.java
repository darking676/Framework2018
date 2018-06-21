package com.bit.spring06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DefaultController implements Controller {
	private String viewName;
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView(viewName);
	}

}
