package com.sf.frs.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sf.frs.main.beans.FlightBean;
import com.sf.frs.main.beans.PassengerBean;
import com.sf.frs.main.beans.ReservationBean;
import com.sf.frs.main.beans.Role;
import com.sf.frs.main.beans.RoleName;
import com.sf.frs.main.beans.RouteBean;
import com.sf.frs.main.beans.ScheduleBean;
import com.sf.frs.main.beans.User;
import com.sf.frs.main.dao.RoleRepository;
import com.sf.frs.main.dao.UserRepository;
import com.sf.frs.main.exceptions.AppException;
import com.sf.frs.main.payload.ApiResponse;
import com.sf.frs.main.payload.JwtAuthenticationResponse;
import com.sf.frs.main.payload.LoginRequest;
import com.sf.frs.main.payload.SignUpRequest;
import com.sf.frs.main.security.JwtTokenProvider;
import com.sf.frs.main.services.FlightServices;
import com.sf.frs.main.services.PassengerServices;
import com.sf.frs.main.services.ReservationServices;
import com.sf.frs.main.services.RouteServices;
import com.sf.frs.main.services.ScheduleServices;
import com.sf.frs.main.services.UserService;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	UserService userService;

	@Autowired
	private FlightServices flightServices;

	@Autowired
	private RouteServices routeServices;

	@Autowired
	private PassengerServices passengerServices;

	@Autowired
	private ScheduleServices scheduleServices;

	@Autowired
	private ReservationServices reservationServices;

	@GetMapping("/userdetails")
	public List<User> getAllusers() {

		return userService.getAllusers();
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ApiResponse(false, "Email Address already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(null, signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getPassword(), signUpRequest.getCity(), signUpRequest.getDateOfBirth(),
				signUpRequest.getFirstName(), signUpRequest.getGender(), signUpRequest.getLastName(),
				signUpRequest.getLocation(), signUpRequest.getMobileNo(), signUpRequest.getState(),
				signUpRequest.getStreet(), signUpRequest.getPincode(), null, null);

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new AppException("User Role not set."));

		user.setRoles(Collections.singleton(userRole));

		User result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
				.buildAndExpand(result.getUsername()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

	}

//	----------------------------FRS CONTROLLER------------------------------------------

//	Flight Controller

	@GetMapping("/getallFlights")
	public List<FlightBean> getallFlights() {

		return flightServices.getAllFlights();
	}

//	@PostMapping("/AddFlight")
//	public FlightBean createflight(@RequestBody FlightBean flightBean) {
//		return flightServices.createFlight(flightBean);
//	}
//	
	 @PostMapping("/AddFlight")
	    public FlightBean createFlight(@RequestBody FlightBean flight) {
	        return flightServices.saveFlight(flight);
	    }

	@GetMapping("/flight/{id}")
	public ResponseEntity<FlightBean> getFlightId(@PathVariable Integer id) {
		FlightBean flightBean = flightServices.getFlightById(id);
		return ResponseEntity.ok(flightBean);

	}

	@PutMapping("/updateflight/{id}")
	public ResponseEntity<FlightBean> updateFlight(@PathVariable Integer id, @RequestBody FlightBean flight) {

		FlightBean flightBean = flightServices.updateFlight(id, flight);
		return ResponseEntity.ok(flightBean);

	}

	@DeleteMapping("/deleteflight/{flightID}")
	public ResponseEntity<Map<String, Boolean>> deleteflight(@PathVariable Integer flightID) {
		flightServices.deleteflight(flightID);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

//	   Passenger Controller

	@GetMapping("/getallPassengers")
	public List<PassengerBean> getAllPassengers() {

		return passengerServices.getAllPassengers();

	}

	@PostMapping("/AddPassenger")
	public PassengerBean createPassenger(@RequestBody PassengerBean passengerBean) {
		return passengerServices.createPassenger(passengerBean);
	}

//	   Route Controller

	@GetMapping("/getallRoutes")
	public List<RouteBean> getAllRoutes() {

		return routeServices.getAllRoutes();
	}

	@PostMapping("/AddRoute")
	public RouteBean createRoute(@RequestBody RouteBean routeBean) {
		return routeServices.createRoute(routeBean);
	}

	@GetMapping("/route/{id}")
	public ResponseEntity<RouteBean> getrouteId(@PathVariable Integer id) {
		RouteBean routeBean = routeServices.getRouteById(id);
		return ResponseEntity.ok(routeBean);

	}

	@PutMapping("/updateroute/{id}")
	public ResponseEntity<RouteBean> updateRoute(@PathVariable Integer id, @RequestBody RouteBean routeBean) {

		RouteBean route = routeServices.updateroute(id, routeBean);
		return ResponseEntity.ok(route);

	}

	@DeleteMapping("/deleteflightroute/{routeID}")
	public ResponseEntity<Map<String, Boolean>> deleteflightroute(@PathVariable Integer routeID) {
		routeServices.deleteRoute(routeID);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

//	   Schedule Controller

	@GetMapping("/getallSchedules")
	public List<ScheduleBean> getAllSchedules() {

		return scheduleServices.getAllSchedules();
	}

	@PostMapping("/AddSchedule")
	public ScheduleBean createSchedule(@RequestBody ScheduleBean scheduleBean) {
		return scheduleServices.createSchedule(scheduleBean);
	}
	
	@DeleteMapping("/deleteSchedule/{scheduleID}")
	public ResponseEntity<Map<String, Boolean>> deleteSchedule(@PathVariable Integer scheduleID) {
		scheduleServices.deleteSchedule(scheduleID);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


//	   Reservation Controller

	@GetMapping("/getallReservations")
	public List<ReservationBean> getAllReservations() {

		return reservationServices.getallReservations();
	}

	@PostMapping("/AddReservation")
	public ReservationBean createReservation(@RequestBody ReservationBean reservationBean) {
		return reservationServices.createReservation(reservationBean);
	}

}