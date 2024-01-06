package com.ecom.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.model.State;
import com.ecom.app.repository.StateRepository;
import com.ecom.app.service.StateService;

@Service
public class StateServiceImpl implements StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public List<State> getAllState(){
		return stateRepository.findAll();
	}

}
