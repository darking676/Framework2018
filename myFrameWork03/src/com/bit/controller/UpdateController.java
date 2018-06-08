package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.model.GuestDao;
import com.bit.model.entity.GuestVo;
import com.bit.utils.BitController;

public class UpdateController implements BitController {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		String param1=req.getParameter("sabun");
		String param2=req.getParameter("name");
		String param3=req.getParameter("pay");
		
		int result=new GuestDao().updateOne(new GuestVo(
				Integer.parseInt(param1)
				,param2
				,null
				,Integer.parseInt(param3)
				));
		if(result>0){
			return "redirect:detail.do?idx="+param1;
		}else{
			return "redirect:edit.do?idx="+param1;
		}
	}

}
