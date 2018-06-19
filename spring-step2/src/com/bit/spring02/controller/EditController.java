package com.bit.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring02.model.GuestDao1;

public class EditController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idx=request.getParameter("idx");
		
		ModelAndView mav = new ModelAndView();
		GuestDao1 dao =new GuestDao1();
		mav.addObject("bean", dao.selectOne(Integer.parseInt(idx)));
		mav.setViewName("edit");
		return mav;
	}

}
