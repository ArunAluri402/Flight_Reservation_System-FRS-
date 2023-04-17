package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.beans.FlightBean;

public interface FlightDAO extends JpaRepository<FlightBean, Integer> {

}
