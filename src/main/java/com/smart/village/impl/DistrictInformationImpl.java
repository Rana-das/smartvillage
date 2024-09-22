package com.smart.village.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.smart.village.model.DistrictInformation;
import com.smart.village.repository.DistrictInformationRepo;

public class DistrictInformationImpl implements DistrictInformationRepo {

	@Autowired
	DistrictInformationRepo districtInformationRepo;
	@Override
	public List<DistrictInformation> findAll() {
		// TODO Auto-generated method stub
		return districtInformationRepo.findAll();
	}

	@Override
	public List<DistrictInformation> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DistrictInformation> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DistrictInformation> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends DistrictInformation> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<DistrictInformation> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DistrictInformation getOne(String id) {
		// TODO Auto-generated method stub
		return districtInformationRepo.getOne(id);
	}

	@Override
	public <S extends DistrictInformation> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DistrictInformation> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DistrictInformation> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DistrictInformation> S save(S entity) {
		// TODO Auto-generated method stub
		return districtInformationRepo.save(entity);
	}

	@Override
	public Optional<DistrictInformation> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DistrictInformation entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends DistrictInformation> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends DistrictInformation> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DistrictInformation> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DistrictInformation> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends DistrictInformation> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DistrictInformation> findByisoCode(String isoCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DistrictInformation> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DistrictInformation> findBydivision(String division) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DistrictInformation> findBydivisionIssoCode(String divisionIssoCode) {
		// TODO Auto-generated method stub
		return districtInformationRepo.findBydivisionIssoCode(divisionIssoCode);
	}

}
