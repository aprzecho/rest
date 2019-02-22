package com.aprzecho.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprzecho.domain.User;
import com.aprzecho.repository.UserRepository;

@Service
public class UserService {
	
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public User save(final User user) {
		return userRepository.save(user);
	}

	public User findById(final long id) {
		return userRepository.findOne(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User update(final long id, final User user) {

		if (findById(id) != null) {
			user.setId(id);
			return save(user);
		} else {
			throw new NoSuchElementException();
		}
	}

	public void deleteById(final long id) {
		userRepository.delete(id);
	}
}