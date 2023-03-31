package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.bean.PassengerBean;

public interface PassengerRepository extends JpaRepository<PassengerBean, Integer> {

}
