package com.smart.village.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smart.village.model.DistrictInformation;
import com.smart.village.model.UserSms;
import com.smart.village.repository.DistrictInformationRepo;
import com.smart.village.repository.UserSmsRepo;
import com.smart.village.util.Service;

@Controller
public class HomeController {
	
	@Autowired
	Service service;
	
	@Autowired
	DistrictInformationRepo districtInformationRepo;
	
	@Autowired
	UserSmsRepo userSmsRepo;
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title","Smart visitor");
		return "index";
	}
	@GetMapping("/head")
    public String headOfice() {	 
	 	System.out.println("head is ok");
        return "registration";
    }
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(@ModelAttribute("userSms") UserSms userSms, BindingResult result)
	{
		service.sendSms(userSms);
		userSmsRepo.save(userSms);	
		return "contact-success"; 
	}
	@GetMapping("/head/divisionInf")
	public String districtInformation()
	{
		return "divisionform";
	}
	@PostMapping("/head/saveDistrictData")
	public String saveDistrictData(@ModelAttribute("districtInformation") DistrictInformation districtInformation)
	{
		System.out.println(districtInformation.toString());
		districtInformationRepo.save(districtInformation);
		return "redirect:/head/divisionInf";
	}

}
