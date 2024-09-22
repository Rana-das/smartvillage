package com.smart.village.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.village.model.CarGarageInformation;
import com.smart.village.model.User;

public interface CarGarageRepo extends JpaRepository<CarGarageInformation,Integer> {
	//pagination...
	
	@Query("from CarGarageInformation as c where c.user.issocode =:userId")
	//currentPage-pag
	//Contact Per page - 5
	public Page<CarGarageInformation> findCarGarageInformationByUser(@Param("userId")String userId, Pageable pePageable);
	
	//search
	public List<CarGarageInformation> findByNameContainingAndUser(String name,User user);
	@Query("from CarGarageInformation as c where c.user.issocode =:userId")
	public List<CarGarageInformation> findCarGarageInformationById(@Param("userId")String userId);
	
	public Optional<CarGarageInformation> findById(Integer id);
}
