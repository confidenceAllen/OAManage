package com.cn.loan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.loan.service.ActivitiService;

@Controller
@RequestMapping("/sign")
public class LoginController {
	
	@Autowired
	private ActivitiService activitiService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpSession session){
		
		if(session.getAttribute("user")!=null){
			return "main";
		}else {			
			Boolean check = activitiService.login(request);
			if(check){
				User user = activitiService.getUserInfo(request);
				session.setAttribute("user", user);
				return "main";
			}else {
				return null;
			}
		}		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpSession session){		
		session.removeAttribute("user");
		return "sys/logout";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request,Model model){		
		return "sys/register";
	}
	
	@RequestMapping("/signin")
	public String register(HttpServletRequest request,Model model,
			@RequestParam String userName,@RequestParam String password,@RequestParam String email,
			@RequestParam String fristName,@RequestParam String lastName){
		activitiService.createUser(request);
		return "sys/register";
	}
}
