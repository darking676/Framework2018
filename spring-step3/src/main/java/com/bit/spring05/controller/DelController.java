package com.bit.spring05.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring05.model.GuestDao;
import com.bit.spring05.model.GuestDaoImf;

public class DelController extends AbstractController {
	GuestDao dao;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		dao.deleteOne(Integer.parseInt(request.getParameter("idx")));
		return new ModelAndView("redirect:/guest/list.bit");
	}

}
