package com.bit.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring02.model.GuestDao1;
import com.bit.spring02.model.entity.GuestVo;

public class AddController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(req.getMethod().equals("GET")){
			mav.setViewName("add");
			return mav;
		}
		
		GuestVo bean=new GuestVo();
		bean.setName(req.getParameter("name"));
		bean.setPay(Integer.parseInt(req.getParameter("pay")));
		
		GuestDao1 dao = new GuestDao1();
		dao.insertOne(bean);

		mav.setViewName("redirect:/list.bit");
		return mav;
	}

}
