package ua.step.smirnova.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable =  false, updatable = false)
	private int id;

	@Column(nullable = false, unique = true)
	@Type(type = "text")
	private String username;

	@Column(nullable = false, unique = true)
	@Type(type = "text")
	private String email;
	
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column
	@OneToMany
	private Set<Track> likedTracks;

	@Column
	@OneToMany
	private Set<Album> likedAlbums;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	public Set<Track> getLikedTracks() {
		return likedTracks;
	}

	public void setLikedTracks(Set<Track> likedTracks) {
		this.likedTracks = likedTracks;
	}

	public Set<Album> getLikedAlbums() {
		return likedAlbums;
	}

	public void setLikedAlbums(Set<Album> likedAlbums) {
		this.likedAlbums = likedAlbums;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	
}
