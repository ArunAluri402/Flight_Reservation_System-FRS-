package com.sf.frs.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.frs.main.beans.ScheduleBean;
import com.sf.frs.main.dao.ScheduleDAO;
import com.sf.frs.main.exceptions.DataNotFound;

@Service
public class ScheduleServices {

	@Autowired
	private ScheduleDAO scheduleDAO;
	
	  public List<ScheduleBean> getAllSchedules(){
	        return scheduleDAO.findAll();
	    }

	  public ScheduleBean getScheduleById(Integer id){
	        return scheduleDAO.findById(id)
	            .orElseThrow(() -> new DataNotFound("Schedule with id : "+id+" not exists"));
	    }
	  
	  public ScheduleBean createSchedule(ScheduleBean scheduleBean ){
	        return scheduleDAO.save(scheduleBean);
	    }

	  
	  public void deleteSchedule(Integer id){
	        ScheduleBean scheduleBean = scheduleDAO.findById(id)
	            .orElseThrow(() -> new DataNotFound("Schedule with id : "+id+" not exists"));

	        scheduleDAO.delete(scheduleBean);
	    }
}
