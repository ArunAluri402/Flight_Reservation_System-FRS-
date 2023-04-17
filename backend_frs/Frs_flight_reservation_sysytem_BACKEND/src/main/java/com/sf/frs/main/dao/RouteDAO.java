package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.beans.RouteBean;

public interface RouteDAO extends JpaRepository<RouteBean, Integer> {

}
