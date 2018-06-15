package com.bit.struts2.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class DefaultAction implements Action {
	Logger log = Logger.getLogger(getClass());

	@Override
	public String execute() throws Exception {
		log.debug("view 호출");
		return this.SUCCESS;
	}

}
