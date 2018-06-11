package com.bit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;
import com.bit.utils.BitController;

public class UpdateController implements BitController {

	@Override
	public String execute(HttpServletRequest req) {
		String param1=req.getParameter("sabun");
		String param2=req.getParameter("name");
		String param3=req.getParameter("pay");
		// 무결성 검증
		GuestVo bean = new GuestVo(
				Integer.parseInt(param1)
				, param2, null, Integer.parseInt(param3));
		
		GuestDao dao = new GuestDao();
		try {
			if(dao.updateOne(bean)>0){
				return "redirect:detail.do?idx="+param1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:edit.do?idx="+param1;			
	}

}
