package com.smart.village.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.smart.village.model.UniversityInformation;
import com.smart.village.model.User;
import com.smart.village.repository.UniversityRepo;
import com.smart.village.repository.UserRepo;

@Controller
@RequestMapping("/admin")
public class UniversityController {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	UniversityRepo universityRepo;
	
	UniversityInformation  universityInformation;

	
	@GetMapping("/university")
	public String hospital(Model model,Principal principal)
	 {
		 String name = principal.getName();
			User user = this.userRepo.getUserByUserName(name);	
			model.addAttribute("user", user);
		 
		return "universityForm";
	}
	
	@PostMapping("/saveuniversityInformation")
	public String savehospitalInformation(@Valid @ModelAttribute UniversityInformation universityInformation,@RequestParam("image") MultipartFile file,
			Principal principal,Model model) {
		System.out.println(universityInformation.toString());
		 	String name = principal.getName();
			User user = this.userRepo.getUserByUserName(name);	
			model.addAttribute("user", user);
try {

				

				// processing and uploading file..

				if (file.isEmpty()) {
					// if the file is empty then try our message
					System.out.println("File is empty");
					universityInformation.setImageUrl("contact.png");

				} else {
					// file the file to folder and update the name to contact
					universityInformation.setImageUrl(file.getOriginalFilename());

					File saveFile = new ClassPathResource("static/img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

					System.out.println("Image is uploaded");

				}
				
				user.getUniversityInformation().add(universityInformation);

				universityInformation.setUser(user);

				this.userRepo.save(user);	

				

			
			} catch (Exception e) {
				System.out.println("ERROR " + e.getMessage());
				e.printStackTrace();
				// message error
				//session.setAttribute("message", new Message("Some went wrong !! Try again..", "danger"));

			}
			
					
			
		return "redirect:/admin/show_universityInfo/0";	
	}
	@GetMapping("/show_universityInfo/{page}")
	public String showHospital(@PathVariable("page") Integer page, Model model,Principal principal)
		 {
			 String name = principal.getName();
				User user = this.userRepo.getUserByUserName(name);	
				model.addAttribute("user", user);
				
				Pageable pageable = PageRequest.of(page, 2);
				Page<UniversityInformation> universityInformation = this.universityRepo.findUniversityInformationByUser(user.getIssocode(), pageable);				
				model.addAttribute("universityInformation", universityInformation);
				model.addAttribute("currentPage", page);
				model.addAttribute("totalPages", universityInformation.getTotalPages());

			 
			return "show_universityInfo";
	}
	
	// showing particular contact details.

		@RequestMapping("/{cId}/contact-university")
		public String showhospitalInfoDetail(@PathVariable("cId") Integer cId, Model model, Principal principal) {
			System.out.println("CID " + cId);

			Optional<UniversityInformation> contactOptional = this.universityRepo.findById(cId);
			UniversityInformation universityInformation = contactOptional.get();

			//
			String userName = principal.getName();
			User user = this.userRepo.getUserByUserName(userName);

			if (user.getIssocode() == universityInformation.getUser().getIssocode()) {
				model.addAttribute("contact", universityInformation);
				model.addAttribute("title", universityInformation.getName());
			}

			return "normal/contact_detail";
		}
		
		// delete contact handler

		@GetMapping("/delete-university/{cid}")
		@Transactional
		public String deleteContact(@PathVariable("cid") Integer cId, Model model, HttpSession session,
				Principal principal) {
			System.out.println("CID " + cId);

			UniversityInformation universityInformation = this.universityRepo.findById(cId).get();
			// check...Assignment..image delete

			// delete old photo

			User user = this.userRepo.getUserByUserName(principal.getName());

			user.getUniversityInformation().remove(universityInformation);

			this.userRepo.save(user);

			System.out.println("DELETED");
			session.setAttribute("message", new Message("Contact deleted succesfully...", "success"));

			return "redirect:/admin/show_universityInfo/0";
		}
		
		// open update form handler
		@PostMapping("/update-university/{cid}")
		public String updateForm(@PathVariable("cid") Integer cid, Model m, Principal principal) {
			
			String name = principal.getName();
			User user = this.userRepo.getUserByUserName(name);	
			m.addAttribute("user", user);

			m.addAttribute("title", "Update Contact");

			UniversityInformation universityInformation = this.universityRepo.findById(cid).get();

			m.addAttribute("universityInformation", universityInformation);
			System.out.println("ooooooooooooooo........");

			return "university_update_form";
		}
		

}
