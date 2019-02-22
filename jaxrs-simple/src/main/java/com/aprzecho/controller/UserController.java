package com.aprzecho.controller;

import com.aprzecho.domain.User;
import com.aprzecho.service.UserService;

/**
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
**/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("users")
//@Api(value = "/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
	
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostConstruct
	public void init() {
		log.debug("UserController created.");
	}

	@Autowired
	private UserService userService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User save(final User user) {
		return userService.save(user);
	}

	@GET
	@Path("/{id}")
//	@ApiOperation(value = "Find user by Id")
	public User findById(@PathParam("id") final long userId) {
		return userService.findById(userId);
	}

	@GET
	@Path("/all")
//	@ApiOperation(value = "Find all users", response = User.class)
	public List<User> findAll() {
		return userService.findAll();
	}

	@PUT
	@Path("/{id}")
//	@ApiOperation(value = "Updates user by Id")
	public User update(@PathParam("id") final long id, final User user) {
		return userService.update(id, user);
	}

	@DELETE
	@Path("/{id}")
//	@ApiOperation(value = "Deletes user by Id")
	public void deleteById(@PathParam("id") final long userId) {
		userService.deleteById(userId);
	}
}
