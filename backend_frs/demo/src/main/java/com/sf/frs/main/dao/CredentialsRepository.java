package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sf.frs.main.bean.CredentialsBean;

public interface CredentialsRepository extends JpaRepository<CredentialsBean, Integer> {
	 CredentialsBean findByUserID(int userID);
	 
//	 public boolean isAdmin(CredentialsBean credentials) {
//		    // Check if the user is an admin based on their userType attribute
//		    return credentials.getUserType().equals("admin");
//		}

   

}
