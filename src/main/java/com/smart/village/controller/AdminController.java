package com.smart.village.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.smart.village.model.DistrictInformation;
import com.smart.village.model.HospitlInformation;
import com.smart.village.model.User;
import com.smart.village.repository.DistrictInformationRepo;
import com.smart.village.repository.UserRepo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	DistrictInformationRepo districtInformationRepo;
	@Autowired
	UserRepo userRepo;
	//@Autowired
	User user;
	
	  @Autowired private 
	  BCryptPasswordEncoder passwordEncoder;
	 
	

	@GetMapping("/dashboard")
	public String admin(Model model,Principal principal)
	
	{
		String name = principal.getName();
		User user = this.userRepo.getUserByUserName(name);
		model.addAttribute("user", user);
		return "dashboard";
	}
	
	@PostMapping("/districtInfSave")
	public String districtOfMymensingh(@ModelAttribute("dInformation") DistrictInformation dInformation)
	{
		System.out.println("ok........."+dInformation.toString());
		districtInformationRepo.save(dInformation);
        return "redirect:/admin";
	}
	 
	 @GetMapping("/profile")
	 public String profile(Model model,Principal principal)
	 {
		 String name = principal.getName();
			User user = this.userRepo.getUserByUserName(name);	
			model.addAttribute("user", user);
		 model.addAttribute("user", user);
		 return "/profile";
	 }
	 
	 @PostMapping("/saveAdmin")
	 public String saveAdmin(@ModelAttribute User adminInformation,@RequestParam("profileImage") MultipartFile file,
				Principal principal, HttpSession session)
	 {
		 
			adminInformation.setRole("ROLE_ADMIN");
			//adminInformation.setRole("ROLE_USER");
			adminInformation.setEnabled(true);	
			
			adminInformation.setPassword(passwordEncoder.encode(adminInformation.getPassword()));
			try {

				

				// processing and uploading file..

				if (file.isEmpty()) {
					// if the file is empty then try our message
					System.out.println("File is empty");
					adminInformation.setImageUrl("contact.png");

				} else {
					// file the file to folder and update the name to contact
					adminInformation.setImageUrl(file.getOriginalFilename());

					File saveFile = new ClassPathResource("static/img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

					System.out.println("Image is uploaded");

				}
				
				userRepo.save(adminInformation);

				

			
			} catch (Exception e) {
				System.out.println("ERROR " + e.getMessage());
				e.printStackTrace();
				// message error
				//session.setAttribute("message", new Message("Some went wrong !! Try again..", "danger"));

			}
		 
		 return "registration";
	 }
	@PostMapping("admin/updateProfile")
	 public String editProfile(
			 	@RequestParam("username") String username,
				@RequestParam("email") String email,
				@RequestParam("phone") String phone,
				@RequestParam("nationality") String nationality,
				@RequestParam("address") String address,
				@RequestParam("website") String website,
				@RequestParam("twitter") String twitter,
				@RequestParam("instagram") String instagram,
				@RequestParam("facebook") String facebook,
				@RequestParam("profileImage") MultipartFile file,
				Model model, HttpSession session, Principal principal) {
		
	
		try {

			// old contact details
			String name = principal.getName();
			User user = this.userRepo.getUserByUserName(name);
						System.out.println(user.toString());

			// processing and uploading file..

			if (file.isEmpty()) {
				// if the file is empty then try our message
				System.out.println("File is empty");
				//user.setImageUrl("contact.png");

			} else {
				// file the file to folder and update the name to contact
				user.setImageUrl(file.getOriginalFilename());

				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				System.out.println("Image is uploaded");

			}
			user.setAddress(address);
			user.setEmail(email);
			user.setFacebook(facebook);
			user.setPhone(phone);
			user.setInstagram(instagram);
			user.setNationality(nationality);
			user.setTwitter(twitter);
			user.setUsername(username);
			
			userRepo.save(user);

			

		
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			e.printStackTrace();
			// message error
			//session.setAttribute("message", new Message("Some went wrong !! Try again..", "danger"));

		}
		String name = principal.getName();
		User user = this.userRepo.getUserByUserName(name);	
		model.addAttribute("user", user);
		
		System.out.println("return \"redirect:admin/profile\";");
		 
			
		return "redirect:/admin/profile";	
	}
	@GetMapping("/editProfile")
	public String editProfile(Model model,Principal principal)
	 {
		 String name = principal.getName();
			User user = this.userRepo.getUserByUserName(name);	
			model.addAttribute("user", user);
		 
		 
	 
		return "edit_profile";
		
	}
	
			
}
