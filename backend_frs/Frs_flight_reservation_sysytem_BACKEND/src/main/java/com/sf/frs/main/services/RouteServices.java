package com.sf.frs.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sf.frs.main.beans.RouteBean;
import com.sf.frs.main.dao.RouteDAO;
import com.sf.frs.main.exceptions.DataNotFound;

@Service
public class RouteServices {

	@Autowired
	private RouteDAO routeDAO;
	
	  public List<RouteBean> getAllRoutes(){
	        return routeDAO.findAll();
	    }

	  public RouteBean getRouteById(Integer id){
	        return routeDAO.findById(id)
	            .orElseThrow(() -> new DataNotFound("Route with id : "+id+" not exists"));
	    }
	  
	  public RouteBean createRoute(RouteBean routeBean){
	        return routeDAO.save(routeBean);
	    }

	  
	  public void deleteRoute(Integer id){
	        RouteBean routeBean = routeDAO.findById(id)
	            .orElseThrow(() -> new DataNotFound("Route with id : "+id+" not exists"));

	        routeDAO.delete(routeBean);
	    }
	  
	  public RouteBean updateroute(Integer id, RouteBean route) {
			RouteBean routebean = routeDAO.findById(id)
		            .orElseThrow(() -> new DataNotFound("Route with id : "+id+" not exists"));

		       routebean.setSource(route.getSource());
		       routebean.setDestination(route.getDestination());
		       routebean.setFare(route.getFare());
		       routebean.setDistance(route.getDistance());
		       
		       return routeDAO.save(routebean);

		       
		}

}
