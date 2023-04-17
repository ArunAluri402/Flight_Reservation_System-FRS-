package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.beans.PassengerBean;

public interface PassengerDAO extends JpaRepository<PassengerBean, Integer> {

}
