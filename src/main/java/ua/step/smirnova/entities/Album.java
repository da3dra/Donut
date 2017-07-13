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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "albums")
public class Album implements Serializable {

	// переделать на лонг!
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int id;

	@Column
	@Type(type = "text")
	private String title;

	@Column
	@ElementCollection
	@ManyToMany(mappedBy = "albums",cascade = CascadeType.REMOVE)
	private Set<Artist> artists = new HashSet<>();

	@Column(name = "tracks")
	@ElementCollection
	// почему не стоит использ-ть эту аннотацию с кастомными классами ???
	private Set<Track> tracks = new HashSet<>();

	@Column
	@ElementCollection
	@OneToMany
	private Set<Genre> genres = new HashSet<>();

	@Column
	private String cover;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Artist> getArtists() {
		return artists;
	}

	public void addArtist(Artist artist) {
		artists.add(artist);
	}

	public void setArtists(Set<Artist> artists) {
		this.artists = artists;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public int getId() {
		return id;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public void addGenre(Genre g) {
		genres.add(g);
	}

}
