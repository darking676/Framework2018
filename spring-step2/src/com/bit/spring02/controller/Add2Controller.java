package com.bit.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring02.model.GuestDao1;
import com.bit.spring02.model.entity.GuestVo;

public class Add2Controller extends AbstractController {
	
	public Add2Controller() {
		System.out.println("AddController create...");
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		GuestVo bean=new GuestVo();
		bean.setName(req.getParameter("name"));
		bean.setPay(Integer.parseInt(req.getParameter("pay") ));
		
		GuestDao1 dao = new GuestDao1();
		dao.insertOne(bean);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list.bit");
		return mav;
	}

}











