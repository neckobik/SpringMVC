package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		
		//create a student obj
		Student theStudent = new Student();
		
		//add student object to the model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent){
		
		//log the input
		System.out.println("TheStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		System.out.println("Country: " + theStudent.getCountry());
		
		return "student-confirmation";
	}

}