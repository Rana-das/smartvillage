package com.smart.village.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.village.model.HospitlInformation;
import com.smart.village.model.User;

public interface HospitalInfoRepo extends JpaRepository<HospitlInformation,Integer>  {

	//pagination...
	
		@Query("from HospitlInformation as c where c.user.issocode =:userId")
		//currentPage-page
		//Contact Per page - 5
		public Page<HospitlInformation> findHospitlInformationByUser(@Param("userId")String userId, Pageable pePageable);
		
		//search
		public List<HospitlInformation> findByNameContainingAndUser(String name,User user);
		@Query("from HospitlInformation as c where c.user.issocode =:userId")
		public List<HospitlInformation> findHospitlInformationById(@Param("userId")String userId);
		
		public Optional<HospitlInformation> findById(Integer id);
}