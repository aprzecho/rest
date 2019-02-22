package com.aprzecho.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.aprzecho.domain.User;

@Repository
public class UserRepository {
	
	private Map<Long, User> users;
	
	@PostConstruct
	public void init() {
		users = new HashMap<>();
		users.put(1L, new User(1L, "Test", "Testowy"));
	}

	public User save(User user) {
		users.put(user.getId(), user);
		return user;
	}

	public User findOne(long id) {
		return users.get(id);
	}

	public List<User> findAll() {
		return new ArrayList<User>(users.values());
	}

	public void delete(long id) {		
		users.remove(id);
	}

}
