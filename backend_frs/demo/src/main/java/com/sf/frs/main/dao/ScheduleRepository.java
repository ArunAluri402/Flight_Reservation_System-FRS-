package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.bean.ScheduleBean;

public interface ScheduleRepository extends JpaRepository<ScheduleBean, Integer> {

}
