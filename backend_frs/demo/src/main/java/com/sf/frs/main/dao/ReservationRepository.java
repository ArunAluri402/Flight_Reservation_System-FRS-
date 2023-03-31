package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.bean.ReservationBean;

public interface ReservationRepository extends JpaRepository<ReservationBean, Integer> {

}
