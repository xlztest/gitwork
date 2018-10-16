package com.example.my_template.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {

	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected HttpSession session;
	
	@ModelAttribute
	public void setServletAPI(HttpServletRequest request,
			HttpServletResponse response){
		
		this.request = request;
		this.response = response;
		session = request.getSession();
	}
	
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	

}
