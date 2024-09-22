package com.smart.village.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.village.model.HistoricalPlaceInformation;
import com.smart.village.model.HospitlInformation;
import com.smart.village.model.UniversityInformation;
import com.smart.village.model.User;

public interface HistoricalPlaceRepo extends JpaRepository<HistoricalPlaceInformation,Integer> {
	//pagination...
	
			@Query("from HistoricalPlaceInformation as c where c.user.issocode =:userId")
			//currentPage-page
			//Contact Per page - 5
			public Page<HistoricalPlaceInformation> findHistoricalPlaceInformationByUser(@Param("userId")String userId, Pageable pePageable);
			
			//search
			public List<HistoricalPlaceInformation> findByNameContainingAndUser(String name,User user);
			@Query("from HistoricalPlaceInformation as c where c.user.issocode =:userId")
			public List<HistoricalPlaceInformation> findHistoricalPlaceInformationById(@Param("userId")String userId);
			
			public Optional<HistoricalPlaceInformation> findById(Integer id);
	}
