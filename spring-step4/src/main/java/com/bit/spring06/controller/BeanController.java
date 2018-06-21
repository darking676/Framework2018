package com.bit.spring06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring06.model.GuestDao;

public class BeanController extends AbstractController {
	private GuestDao guestDao;
	private String viewName;
	
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int sabun=Integer.parseInt(request.getParameter("idx"));
		return new ModelAndView(viewName,"bean",guestDao.selectOne(sabun));
	}

}
