package com.smart.village.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.village.model.UniversityInformation;
import com.smart.village.model.User;

public interface UniversityRepo extends JpaRepository<UniversityInformation,Integer> {
	//pagination...
	
			@Query("from UniversityInformation as c where c.user.issocode =:userId")
			//currentPage-pag
			//Contact Per page - 5
			public Page<UniversityInformation> findUniversityInformationByUser(@Param("userId")String userId, Pageable pePageable);
			
			//search
			public List<UniversityInformation> findByNameContainingAndUser(String name,User user);
			@Query("from UniversityInformation as c where c.user.issocode =:userId")
			public List<UniversityInformation> findUniversityInformationById(@Param("userId")String userId);
			
			public Optional<UniversityInformation> findById(Integer id);
	}
