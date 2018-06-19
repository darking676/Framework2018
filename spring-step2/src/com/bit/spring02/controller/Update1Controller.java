package com.bit.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring02.model.GuestDao1;
import com.bit.spring02.model.entity.GuestVo;

public class Update1Controller extends AbstractController {
	
	public Update1Controller() {
		System.out.println("UpdateController create...");
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		GuestVo bean = new GuestVo(
				Integer.parseInt(request.getParameter("sabun")),
				request.getParameter("name"),null,
				Integer.parseInt(request.getParameter("pay"))
				);
		
		GuestDao1 dao = new GuestDao1();
		int result=dao.updateOne(bean);
		String viewName="redirect:/edit.bit?idx="+bean.getSabun();
		if(result>0)viewName="redirect:/detail.bit?idx="+bean.getSabun();
		mav.setViewName(viewName);
		return mav;
	}

}
