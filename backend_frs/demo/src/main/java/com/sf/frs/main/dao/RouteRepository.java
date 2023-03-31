package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.bean.RouteBean;

public interface RouteRepository extends JpaRepository<RouteBean, Integer> {

}
