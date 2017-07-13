package ua.step.smirnova.service;

import java.util.Collection;
import java.util.Optional;

import ua.step.smirnova.dto.UserCreateForm;
import ua.step.smirnova.entities.User;


public interface UserService {
	Optional<User> getUserById(int id);

	Optional<User> getUserByEmail(String email);

	Collection<User> getAllUsers();

	User create(UserCreateForm form);
}
