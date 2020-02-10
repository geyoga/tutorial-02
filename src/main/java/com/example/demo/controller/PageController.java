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
		String value = "";
		String[] angkaSatuan = {"nol","satu","dua","tiga","empat","lima","enam","tujuh","delapan","sembilan"};
		String[] angkaBelasan = {"sepuluh","sebelas","dua belas","tiga belas","empat belas","lima belas","enam belas","tujuh belas","delapan belas","sembilan belas"};
		
		
		int result = IntNumber1 + IntNumber2;
		
		if (result < 10) {
			value = angkaSatuan[result];
		}
		else if (result < 20) {
			int temp = result;
			temp = temp - 10;
			value = angkaBelasan[temp];
			
		}
		else if (result < 100) {
			int temp = result / 10;
			int mod = result % 10;
			if (mod == 0) {
				value = angkaSatuan[temp] + " puluh";
			}else {
				value = angkaSatuan[temp] + " puluh " + angkaSatuan[mod];
			}
			
		}else {
			value = "Value out of Range";
		}
		
		model.addAttribute("number1", IntNumber1);
		model.addAttribute("number2", IntNumber2);
		model.addAttribute("result", result);
		model.addAttribute("word",value);
		
		return "calculate";
		
	}
	
	

}

