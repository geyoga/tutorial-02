package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
//	
	@RequestMapping("/hello/hello2")
	public String hello2(@RequestParam(value = "name", required = false) 
	String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
//	
	@RequestMapping(value = {"/hello2","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	
	@RequestMapping("/calcu")
	public String calculation(
			@RequestParam(value ="number1") String number1, 
			@RequestParam(value ="number2") String number2,Model model) {
		
		int IntNumber1 = Integer.parseInt(number1);
		int IntNumber2 = Integer.parseInt(number2);
		
		int result = IntNumber1 + IntNumber2;
		
		model.addAttribute("number1", IntNumber1);
		model.addAttribute("number2", IntNumber2);
		model.addAttribute("result", result);
		
		
		return "calculate";
		
	}
	
	

}

