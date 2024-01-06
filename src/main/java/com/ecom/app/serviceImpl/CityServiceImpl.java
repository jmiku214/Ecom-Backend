package com.ecom.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.model.City;
import com.ecom.app.repository.CityRepository;
import com.ecom.app.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public List<City> getAllCityByStateId(Long stateId){
		return cityRepository.findByStateId(stateId);
	}
	
}
