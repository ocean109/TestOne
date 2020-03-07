package com.example.demo.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class DefaultView {
	@GetMapping("/")
	public String view2() {
		return "Login";
	}

}
