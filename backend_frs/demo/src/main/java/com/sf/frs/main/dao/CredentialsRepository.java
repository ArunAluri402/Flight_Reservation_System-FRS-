package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sf.frs.main.bean.CredentialsBean;

public interface CredentialsRepository extends JpaRepository<CredentialsBean, Integer> {

   

}
