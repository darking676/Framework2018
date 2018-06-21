package com.bit.spring06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring06.model.GuestDao;

public class DelController extends AbstractController {
	// 1. 타입 필드명 일치
	// 2. 타입(super O)x 필드명 일치
	// 3. 타입o  필드명 x
	// 4. 타입(super O)x 필드명x
	
	// 1.@Autowired setter
	// 2.@Autowired 필드상단
	
	private GuestDao guestDao;

	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int sabun=Integer.parseInt(request.getParameter("idx"));
		System.out.println(guestDao);
		if(guestDao.deleteOne(sabun)>0)return new ModelAndView("redirect:/list.bit");
		return new ModelAndView("redirect:/detail.bit?idx="+sabun);
	}


}
