package com.fantazy.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fantazy.web.po.User;


@Controller
@RequestMapping("/users")
public class UsersController {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model){
		
		User user = new User();
		user.setUsername("fantazy");
		user.setPassword("123456");
		model.addAttribute("user", user);
		System.out.println("user index controller");
		return "user/index";
	}
	@RequestMapping(value="/index2",method=RequestMethod.GET)
	public String index2(WebRequest webRequest,NativeWebRequest nativeWebRequest){
		
		HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

		String username = webRequest.getParameter("username");
		//request.setAttribute("username", username);
		webRequest.setAttribute("age", 18, WebRequest.SCOPE_REQUEST);
		return "user/index2";
	}
	@RequestMapping(value="/index3",method=RequestMethod.GET)
	public String index3(Model model1,Map model2, ModelMap model3){
		
		System.out.println(model1 == model2);
		System.out.println(model1 == model3);
		model1.addAttribute("age", 21);
		model2.put("username", "小李");
		model3.put("id", "good");
		return "user/index3";
	}
	@RequestMapping(value="/mv",method=RequestMethod.GET)
	public ModelAndView mv(Model model){
		
		ModelAndView mv = new ModelAndView("user/mv");
		mv.addObject("actor", "Jay-Chou");
		model.addAttribute("actor", "Leanode");
		return mv;
	}
	
	@RequestMapping(value="/form" ,method=RequestMethod.GET)
	public String form(){
		
		return "user/form";
	}
}
