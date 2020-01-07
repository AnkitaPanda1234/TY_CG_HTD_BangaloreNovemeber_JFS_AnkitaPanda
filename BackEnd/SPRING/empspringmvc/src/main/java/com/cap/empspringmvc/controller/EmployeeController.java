package com.cap.empspringmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.cap.empspringmvc.bean.EmployeeBean;
import com.cap.empspringmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@PostMapping("/login")
	public String login(String email,String password,
			ModelMap map,HttpServletRequest request)
	{
		EmployeeBean bean=service.auth(email, password);
		if(bean==null)
		{
			map.addAttribute("msg","Invalid Credentials");
			return "login";
		}
		HttpSession session=request.getSession();
		session.setAttribute("bean", bean);
		
		return "home";
	}
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	@PostMapping("/register")
	public String register(EmployeeBean bean,ModelMap map)
	{
		boolean check=service.register(bean);
		if(check)
		{
		map.addAttribute("msg","you have register to the Employee Portal")	;
		}else
		{
			map.addAttribute("msg","This Email already exits");
		}
		return "login";
	}
	@GetMapping("/search")
	public String search(@RequestParam("key")String key,ModelMap map,
			@SessionAttribute(name ="bean",required=false)EmployeeBean bean)
	{
		if(bean!=null)
		{
		
		List<EmployeeBean> list=service.getEmployess(key);
		map.addAttribute("list",list);
		return "home";
	}
		else
		{
			return "login";
		}
	}
	@GetMapping("/home")
	public String home(@SessionAttribute(name="bean", required=false)EmployeeBean bean)
	{
		if(bean!=null) 
		return "home";
		else
			return "login";
	}
	@GetMapping("/changepassword")
	public String changePassword(@SessionAttribute(name="bean", required=false)EmployeeBean bean)
	{
		if(bean!=null)
		return "changepassword";
		else
			return "login";
	}
	
	
	
	@PostMapping("/changepassword")
	public String changePassword(String password,@SessionAttribute("bean") EmployeeBean bean)
	{
		service.changePassword(bean.getId(), password);
		return "home";
	}
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}


}
