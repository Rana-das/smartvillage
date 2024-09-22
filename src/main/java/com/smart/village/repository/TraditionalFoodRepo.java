package com.smart.village.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.village.model.TraditionalFoodInformation;
import com.smart.village.model.User;

public interface TraditionalFoodRepo extends JpaRepository<TraditionalFoodInformation,Integer> {
	//pagination...
	
	@Query("from TraditionalFoodInformation as c where c.user.issocode =:userId")
	//currentPage-pag
	//Contact Per page - 5
	public Page<TraditionalFoodInformation> findTraditionalFoodInformationByUser(@Param("userId")String userId, Pageable pePageable);
	
	//search
	public List<TraditionalFoodInformation> findByNameContainingAndUser(String name,User user);
	@Query("from TraditionalFoodInformation as c where c.user.issocode =:userId")
	public List<TraditionalFoodInformation> findTraditionalFoodInformationById(@Param("userId")String userId);
	
	public Optional<TraditionalFoodInformation> findById(Integer id);
}
