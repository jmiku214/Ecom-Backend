package com.ecom.app.service;

import java.util.List;

import com.ecom.app.model.City;

public interface CityService {

	List<City> getAllCityByStateId(Long stateId);

}
