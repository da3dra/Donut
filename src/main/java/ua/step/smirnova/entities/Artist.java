package ua.step.smirnova.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "artists")
public class Artist implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int id;

	@Column
	@Type(type = "text")
	private String name;

	@Column
	@ElementCollection
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "ARTISTS_ALBUMS", joinColumns = @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID"))
	private Set<Album> albums = new HashSet<>();

	@Column
	@Type(type = "text")
	private String bio;

	public Artist() {
		System.err.println("creating artist");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void addAlbum(Album a) {
		albums.add(a);

	}

}
