package com.cap.springmvc.controller;

import javax.annotation.Generated;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.cap.springmvc.beans.User;

@Controller
public class SpringController {
	@Autowired
	private ServletContext context;
	@RequestMapping("/hello") //method called as handler method
	public String hello(ModelMap map)
	{
		map.addAttribute("msg", "hello World..........");//request attribute
		return "index"; //returning name of jsp file
	}
	//@RequestMapping(path="/query",method =RequestMethod.GET)//override doget method
	@GetMapping("/query") //like as above
	public String query(@RequestParam("name")String name,
			@RequestParam("age")int age,ModelMap map) //convert string to name
	{
		map.addAttribute("name", name);
		map.addAttribute("age",age);
		return "query";
	}
	@GetMapping("/form")
	public String form()
	{
		return "form"; 
	}
	
	@PostMapping("/form")
	
		/*public String form(String name,String email,String password,
				String gender,ModelMap map) //automatically mapping as we have same with in form.jsp
		{
	
		map.addAttribute("name",name);
		map.addAttribute("email",email);
		map.addAttribute("password",password);
		map.addAttribute("gender",gender);
			return "form";
		}*/
	public String form(User user,ModelMap map)//passing object and spring set the data
	{

		map.addAttribute("name",user.getName());
		map.addAttribute("email",user.getEmail());
		map.addAttribute("password",user.getPassword());
		map.addAttribute("gender",user.getGender());
			return "form";
	      }
	
	@GetMapping("/createcookie")
	public String createCookie(HttpServletResponse response)//pass it to cookies
	{
	Cookie cookie=new Cookie("name","Ankita");
	response.addCookie(cookie);
	
	
		return "createcookie";
	}
	
	@GetMapping("/getcookie")
	public String getCookie( ModelMap map,
			@CookieValue(name ="name" ,required=false)String name)
			{
		if(name!=null)
			map.addAttribute("name",name);
		else
			map.addAttribute("name","Ankita");
	
	//spring can do all the iteration by its own to get the cookies
		
		return "getcookie";
	}
	@GetMapping("/path/{movie}/{hero}")//dynamic value
	public String path(@PathVariable("movie")String movie,
			@PathVariable("hero")String hero, ModelMap map)
	{
		map.addAttribute("movie",movie);
		map.addAttribute("hero",hero);
		return "pathvalue";
	}
	@GetMapping("/forward")
	public String forward()
	{
		return "forward:hello"; //forward request to another controller
	}
	@GetMapping("/redirect")
	public String redirect()
	{
		return "redirect:https://www.google.com";
	}
	@GetMapping("/login")
	 public String login()
	 {
		 return "login";
	 }
	@PostMapping("/login")
	public String login(String username,String password,
			HttpServletRequest request,ModelMap map)
	{
		if(username.equals("user")&& password.equals("qwerty"))
		{
			User user=new User();
			user.setName(username);
			user.setEmail("user@gmail.com");
			user.setPassword(password);
			user.setGender("female");
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			map.addAttribute("msg","User logged in");
			return "home";
			
		}
		else
		{
			map.addAttribute("msg","Credentials Invalid");
		}
		return "login";
	}
	 
	   @GetMapping("/home")
	   public String home(@SessionAttribute(name="user",required=false)User user)
	   {
		   if(user!=null)//validate the session by using @SessionAttribute
		   {
			   return "home";
		   }else
		   {
			   return "login";
		   }
		   
	   }
	
	/*@PostMapping("/login")
	 public String login(HttpSession session)
	 {
		return "home";
	 }*/
	   
	   @GetMapping("/setappattribute")
	   public String setAppAttribute()
	   {
		 context.setAttribute("msg", new Object());
		 return "setcontext";
	   }
	   @GetMapping("/getappattribute")
	   public String getAppAttribute()
	   {
		   System.out.println(context.getAttribute("msg"));
		   return "getcontext";
	   }

}

