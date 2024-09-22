package com.smart.village.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class SecurityController {
	
	//handler for custom login
		@GetMapping("/register")
		public String headLogin()
		{
			System.out.println("Security ok");
			
			return "login";
		}
}
