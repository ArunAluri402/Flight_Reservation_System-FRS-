package com.sf.frs.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sf.frs.main.bean.ScheduleBean;
import com.sf.frs.main.dao.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public List<ScheduleBean> getAllSchedules(){
		return scheduleRepository.findAll();
	}
	
	

}


