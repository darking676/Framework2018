package com.bit.spring05.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.bit.spring05.model.GuestDao;
import com.bit.spring05.model.GuestDaoImf;
import com.bit.spring05.model.entity.GuestVo;

public class EditController extends AbstractCommandController{
	private GuestDao dao;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		if(dao.updateOne((GuestVo)command)>0) return new ModelAndView("redirect:/guest/detail.bit?idx="+request.getParameter("sabun"));
		return new ModelAndView("redirect:/guest/edit.bit?idx="+request.getParameter("sabun"));
	}

}
