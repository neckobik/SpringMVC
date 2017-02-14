package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// create method to show the initial HTMLform
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}
	
	// create method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
	
	//new a controller method to read form data and
	//add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String LetsShoutDude(HttpServletRequest request, Model model){
		//read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		
		//convert data to all CAPS
		theName = theName.toUpperCase();
				
		//create the message
		String result = "Yo! " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, 
											Model model){
		
		//convert data to all CAPS
		theName = theName.toUpperCase();
				
		//create the message
		String result = "Bro v3 " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
