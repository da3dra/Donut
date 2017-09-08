package ua.step.smirnova.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int id;

	@Column(nullable = false, unique = true)
	@Type(type = "text")
	private String username;

	@Column(nullable = false, unique = true)
	@Type(type = "text")
	private String email;

	@Column(name = "password_hash", nullable = false)
	@JsonIgnore
	private String passwordHash;

	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column
	private Integer donuts;
	
	@OneToMany
	private Set<Track> likedTracks;

	@OneToMany
	private Set<Album> likedAlbums;

	@OneToMany
	private Set<News> news;

	@OneToMany
	private Set<Album> wishlist;

	@ManyToMany(targetEntity = Artist.class, cascade = CascadeType.ALL)
	@JoinTable(name = "USERS_ARTISTS", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID"))
	@JsonBackReference
	private Set<Artist> following;

	public User() {
		}

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

	public Set<Album> getWishlist() {
		return wishlist;
	}

	public void setWishlist(Set<Album> wishlist) {
		this.wishlist = wishlist;
	}

	public Set<Artist> getFollowing() {
		return following;
	}

	public void setFollowing(Set<Artist> following) {
		this.following = following;
	}

	public Set<News> getNews() {
		return news;
	}

	public void setNews(Set<News> news) {
		this.news = news;
	}


	public Integer getDonuts() {
		return donuts;
	}

	public void setDonuts(Integer donuts) {
		this.donuts = donuts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", role=" + role + ", likedTracks="
				+ likedTracks + ", likedAlbums=" + likedAlbums + ", wishlist=" + wishlist + ", following=" + following
				+ "]";
	}

}
