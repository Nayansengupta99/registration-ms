package com.nayan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayan.model.User;
import com.nayan.repository.UserRepository;

@Service
public class UserRegistrationService {

	@Autowired
	private UserRepository repo;

	public String saveUserData(User user) {

		if (user.getName() == null || user.getEmail() == null || user.getExp() == 0 || user.getDomain() == null) {
			return "Please fill all fields correctly";
		} else {
			for (User u : repo.findAll()) {
				if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
					return user.getEmail() + " is already registered";
				}

			}
			repo.save(user);
			return "User Data Saved Successfully";
		}
	}

	public String deleteDataByName(long id) {
	
				repo.deleteById(id);
			
		
		return "User with userId " + id + " deleted successfully";

	}

	public List<User> getAll() {
		return repo.findAll();
	}

	public User findByName(String name) {
		return repo.findByName(name);
	}

}
