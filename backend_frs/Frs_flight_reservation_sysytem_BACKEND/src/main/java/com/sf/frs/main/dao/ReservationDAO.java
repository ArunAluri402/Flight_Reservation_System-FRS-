package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.beans.ReservationBean;

public interface ReservationDAO extends JpaRepository<ReservationBean, Integer>{

}
