package com.smart.village.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.village.model.UserSms;

public interface UserSmsRepo extends JpaRepository<UserSms,String> {
	
	List<UserSms> findByemail(String email);
	List<UserSms> findByName(String name);
	List<UserSms> findBynumber(String number);

}
