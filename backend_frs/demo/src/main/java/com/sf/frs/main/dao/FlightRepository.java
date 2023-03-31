package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.bean.FlightBean;

public interface FlightRepository extends JpaRepository<FlightBean, Integer> {

}
