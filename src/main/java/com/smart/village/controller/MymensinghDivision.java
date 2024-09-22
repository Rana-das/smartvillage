package com.smart.village.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smart.village.impl.DistrictInformationImpl;
import com.smart.village.model.DistrictInformation;
import com.smart.village.model.LinkClick;
import com.smart.village.repository.DistrictInformationRepo;



@Controller
public class MymensinghDivision {
	
	@Autowired
	LinkClick linkClick;

	@Autowired
	DistrictInformationRepo districtInformationRepo;
	
	@RequestMapping("/district/{url}/{isoCode}")
	 public String showEditCustomerPage(@PathVariable(name = "isoCode") String isoCode ,@PathVariable(name = "url") String url ,Model mav) {
      
		url=url.toLowerCase();
		linkClick.setActive(true);
        DistrictInformation districtInformation=districtInformationRepo.getOne(isoCode);
        linkClick.setDistrictInformation(districtInformation);
        System.out.println(districtInformation.toString());
        System.out.println(url+"............");
        mav.addAttribute("districtInformation", districtInformation);
        return  "redirect:/"+url+"/{isoCode}";
       // return "districInformation";
    }
	@RequestMapping("/details/{isoCode}")
	public String showDetails(@PathVariable(name = "isoCode") String isoCode ,Model mav)
	{
		System.out.println("details...............");
		return "divisionform";
	}

}
