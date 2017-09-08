package ua.step.smirnova.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.step.smirnova.dto.UserCreateForm;
import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.Role;
import ua.step.smirnova.entities.Status;
import ua.step.smirnova.entities.User;
import ua.step.smirnova.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ArtistService artistService;
	private final AlbumService albumService;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, ArtistService artistService, AlbumService albumService) {
		this.userRepository = userRepository;
		this.artistService = artistService;
		this.albumService = albumService;
	}

	@Override
	@Transactional
	public Optional<User> getUserById(int id) {
		return Optional.ofNullable(userRepository.findOne(id));
	}

	@Override
	@Transactional
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	@Transactional
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("email"));
	}

	@Override
	@Transactional
	public User create(UserCreateForm form) {
		if (form.getRole().equals(Role.ARTIST)) {
			Artist artist = new Artist();
			artist.setEmail(form.getEmail());
			artist.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
			artist.setRole(form.getRole());
			artist.setUsername(form.getUsername());
			artist.setStatus(Status.REGULAR);
			return artistService.add(artist);
		}
		User user = new User();
		user.setEmail(form.getEmail());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
		user.setRole(form.getRole());
		user.setUsername(form.getUsername());
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public Optional<User> getUserByUsername(String name) {
		return userRepository.findOneByUsername(name);
	}

	@Override
	@Transactional
	public void follow(User user, Artist artist) {
		user.getFollowing().add(artist);
		artist.getFollowers().add(user);
		artistService.edit(artist);
		this.update(user);
		System.err.println("user "+user+" follows "+user.getFollowing());
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public boolean donate(User user, Artist artist, int toGive) {
		int money = user.getDonuts().intValue();
		if (money < toGive) {
			return false;
		}
		user.setDonuts(user.getDonuts() - toGive);
		if(artist.getDonuts()==null){
			artist.setDonuts(new Integer(0));
		}
		artist.setDonuts(artist.getDonuts() + toGive);
		update(user);
		artistService.edit(artist);
		System.err.println("user balance: "+user.getDonuts());
		System.err.println("artist balance: "+artist.getDonuts());
		return true;
	}
}
