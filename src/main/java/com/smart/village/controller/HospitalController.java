package com.smart.village.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.village.model.HospitlInformation;
import com.smart.village.model.Message;
import com.smart.village.model.User;
import com.smart.village.repository.HospitalInfoRepo;
import com.smart.village.repository.UserRepo;

@Controller
@RequestMapping("/admin")
public class HospitalController {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	HospitalInfoRepo hospitalInfoRepo;
	
	HospitlInformation  hospitlInformation;

	
	@GetMapping("/hospital")
	public String hospital(Model model,Principal principal)
	 {
		 String name = principal.getName();
			User user = this.userRepo.getUserByUserName(name);	
			model.addAttribute("user", user);
		 
		return "hospitalForm";
	}

	@PostMapping("/savehospitalInformation")
	public String savehospitalInformation(@ModelAttribute HospitlInformation hospitlInformation,@RequestParam("image") MultipartFile file,
			Principal principal,Model model) {
		 	String name = principal.getName();
			User user = this.userRepo.getUserByUserName(name);	
			model.addAttribute("user", user);
try {

				

				// processing and uploading file..

				if (file.isEmpty()) {
					// if the file is empty then try our message
					System.out.println("File is empty");
					hospitlInformation.setImageUrl("contact.png");

				} else {
					// file the file to folder and update the name to contact
					hospitlInformation.setImageUrl(file.getOriginalFilename());

					File saveFile = new ClassPathResource("static/img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

					System.out.println("Image is uploaded");

				}
				
				user.getHospitlInformations().add(hospitlInformation);

				hospitlInformation.setUser(user);

				this.userRepo.save(user);	

				

			
			} catch (Exception e) {
				System.out.println("ERROR " + e.getMessage());
				e.printStackTrace();
				// message error
				//session.setAttribute("message", new Message("Some went wrong !! Try again..", "danger"));

			}
			
					
			
		return "redirect:/admin/show_hospitalInfo/0";	
	}
	@GetMapping("/show_hospitalInfo/{page}")
	public String showHospital(@PathVariable("page") Integer page, Model model,Principal principal)
		 {
			 String name = principal.getName();
				User user = this.userRepo.getUserByUserName(name);	
				model.addAttribute("user", user);
				
				Pageable pageable = PageRequest.of(page, 2);
				Page<HospitlInformation> hospitalInfo = this.hospitalInfoRepo.findHospitlInformationByUser(user.getIssocode(), pageable);				
				model.addAttribute("hospitalInfo", hospitalInfo);
				model.addAttribute("currentPage", page);
				model.addAttribute("totalPages", hospitalInfo.getTotalPages());

			 
			return "show_hospitalInfo";
	}
	
	// showing particular contact details.

		@RequestMapping("/{cId}/contact")
		public String showhospitalInfoDetail(@PathVariable("cId") Integer cId, Model model, Principal principal) {
			System.out.println("CID " + cId);

			Optional<HospitlInformation> contactOptional = this.hospitalInfoRepo.findById(cId);
			HospitlInformation hospitlInformation = contactOptional.get();

			//
			String userName = principal.getName();
			User user = this.userRepo.getUserByUserName(userName);

			if (user.getIssocode() == hospitlInformation.getUser().getIssocode()) {
				model.addAttribute("contact", hospitlInformation);
				model.addAttribute("title", hospitlInformation.getName());
			}

			return "normal/contact_detail";
		}
		
		// delete contact handler

		@GetMapping("/delete/{cid}")
		@Transactional
		public String deleteContact(@PathVariable("cid") Integer cId, Model model, HttpSession session,
				Principal principal) {
			System.out.println("CID " + cId);

			HospitlInformation hospitlInformation = this.hospitalInfoRepo.findById(cId).get();
			// check...Assignment..image delete

			// delete old photo

			User user = this.userRepo.getUserByUserName(principal.getName());

			user.getHospitlInformations().remove(hospitlInformation);

			this.userRepo.save(user);

			System.out.println("DELETED");
			session.setAttribute("message", new Message("Contact deleted succesfully...", "success"));

			return "redirect:/admin/show_hospitalInfo/0";
		}
		
		// open update form handler
		@PostMapping("/update-hospital/{cid}")
		public String updateForm(@PathVariable("cid") Integer cid, Model m, Principal principal) {
			
			String name = principal.getName();
			User user = this.userRepo.getUserByUserName(name);	
			m.addAttribute("user", user);

			m.addAttribute("title", "Update Contact");

			HospitlInformation hospitlInformation = this.hospitalInfoRepo.findById(cid).get();

			m.addAttribute("hospitlInformation", hospitlInformation);
			System.out.println("ooooooooooooooo........");

			return "hospital_update_form";
		}
		

}
