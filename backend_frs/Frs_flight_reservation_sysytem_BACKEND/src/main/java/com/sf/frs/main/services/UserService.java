package com.sf.frs.main.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.main.beans.User;
import com.sf.frs.main.dao.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllusers(){
		return userRepository.findAll();
	}
	

}