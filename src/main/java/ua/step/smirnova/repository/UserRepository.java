package ua.step.smirnova.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.smirnova.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findOneByEmail(String email);

}
