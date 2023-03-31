package com.sf.frs.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.main.bean.ProfileBean;
import com.sf.frs.main.dao.ProfileRepository;

@Service
public class UserService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public List<ProfileBean> getAllProfile() {
		return profileRepository.findAll();
	}

}
