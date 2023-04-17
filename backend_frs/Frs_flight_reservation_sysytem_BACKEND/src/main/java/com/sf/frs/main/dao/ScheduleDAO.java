package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.beans.ScheduleBean;

public interface ScheduleDAO extends JpaRepository<ScheduleBean, Integer>{

}
