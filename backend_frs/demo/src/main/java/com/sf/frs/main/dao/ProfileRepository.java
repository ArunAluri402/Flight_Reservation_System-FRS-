package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.bean.ProfileBean;

public interface ProfileRepository extends JpaRepository<ProfileBean, Integer> {

}
