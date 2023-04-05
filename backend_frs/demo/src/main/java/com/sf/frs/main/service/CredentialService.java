package com.sf.frs.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.sf.frs.main.bean.CredentialsBean;
import com.sf.frs.main.bean.FlightBean;
import com.sf.frs.main.dao.CredentialsRepository;
import com.sf.frs.main.dao.FlightRepository;
import com.sf.frs.main.exceptions.ErrorExceptions;
@Service
public class CredentialService {
	@Autowired
	private CredentialsRepository credentialsRepository;
	
	
	@PreAuthorize("userType('Admin')")
	public List<CredentialsBean> getAllCredentials() {
		return credentialsRepository.findAll();
	}
	


}
