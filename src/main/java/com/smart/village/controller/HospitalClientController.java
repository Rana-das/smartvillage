package com.smart.village.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.village.model.HospitlInformation;
import com.smart.village.repository.HospitalInfoRepo;


@Controller
public class HospitalClientController {
	

	@Autowired
	HospitalInfoRepo hospitalInfoRepo;

	@RequestMapping("/hospitalInfo/{cid}")
	public String hospitalInfo(@PathVariable("cid") String cid, Model m) 
	{
		
		List<HospitlInformation> hospitalInfo = this.hospitalInfoRepo.findHospitlInformationById(cid);				
			
		m.addAttribute("hospitalInfo", hospitalInfo);
		
		return "hospitalUserView/hospitalList";
		
	}
	@GetMapping("/image/imageDetails")
	public String hospitalDetails(@RequestParam("id") Integer id,Model model,Optional<HospitlInformation> hospitlInformation)
	
	{
		hospitlInformation=hospitalInfoRepo.findById(id);
		model.addAttribute("imageUrl", hospitlInformation.get().getImageUrl());
		model.addAttribute("name", hospitlInformation.get().getName());
		model.addAttribute("description", hospitlInformation.get().getDescription());
		model.addAttribute("contact", hospitlInformation.get().getContactInfo());
		model.addAttribute("noICU", hospitlInformation.get().getNoOfICU());
		model.addAttribute("link", hospitlInformation.get().getWebsiteLink());

		System.out.println("............."+hospitlInformation.toString());
		return "hospitalUserView/imagedetails";
	}
	
}
