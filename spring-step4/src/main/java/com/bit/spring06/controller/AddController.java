package com.bit.spring06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.AbstractFormController;

import com.bit.spring06.model.GuestDao;
import com.bit.spring06.model.entity.GuestVo;

public class AddController extends AbstractCommandController{
	private GuestDao guestDao;
	
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		GuestVo bean=(GuestVo) command;
		guestDao.insertOne(bean);
		return new ModelAndView("redirect:/list.bit");
	}


}
