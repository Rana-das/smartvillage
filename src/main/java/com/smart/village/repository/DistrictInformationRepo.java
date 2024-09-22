package com.smart.village.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.village.model.DistrictInformation;

public interface DistrictInformationRepo extends JpaRepository<DistrictInformation,String> {
	@Query("from districtInformation as c where c.divisionIssoCode = :divisionIssoCode")
	List<DistrictInformation> findBydivisionIssoCode(@Param("divisionIssoCode")String divisionIssoCode);
	List<DistrictInformation> findByisoCode(String isoCode);
	List<DistrictInformation> findByName(String   name);
	List<DistrictInformation> findBydivision(String division);

}
