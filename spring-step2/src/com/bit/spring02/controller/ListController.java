package com.bit.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring02.model.GuestDao1;

public class ListController implements Controller {
	
	public ListController() {
		System.out.println("ListController create...");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		GuestDao1 dao = new GuestDao1();
//		req.setAttribute("alist", dao.selectAll());
		mav.addObject("alist", dao.selectAll());
		mav.setViewName("list");
		return mav;
	}

}
