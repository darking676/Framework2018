package com.bit.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring02.model.GuestDao1;

public class DeleteController extends AbstractController {
	
	public DeleteController() {
		System.out.println("DeleteController create...");
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idx=request.getParameter("idx");
		GuestDao1 dao = new GuestDao1();
		ModelAndView mav = new ModelAndView("redirect:/detail.bit?idx="+idx);
		if(dao.deleteOne(Integer.parseInt(idx))>0){
			mav = new ModelAndView("redirect:/list.bit");
		}
		return mav;
	}

}
