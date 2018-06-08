package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;
import com.bit.utils.BitController;

public class DetailController implements BitController {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		String param=req.getParameter("idx");
		GuestVo bean = new GuestDao().selectOne(Integer.parseInt(param));
		req.setAttribute("bean", bean);
		return "detail";
	}

}
