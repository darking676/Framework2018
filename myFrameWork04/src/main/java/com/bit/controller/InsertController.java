package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;
import com.bit.utils.BitController;

public class InsertController implements BitController {

	@Override
	public String execute(HttpServletRequest req) {
		String param1=req.getParameter("sabun");
		String param2=req.getParameter("name");
		String param3=req.getParameter("pay");
		
		GuestDao dao = new GuestDao();
		GuestVo bean=new GuestVo();
		bean.setSabun(Integer.parseInt(param1));
		bean.setName(param2);
		bean.setPay(Integer.parseInt(param3));
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list.do";
	}

}
