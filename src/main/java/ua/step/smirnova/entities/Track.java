package ua.step.smirnova.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tracks")
public class Track implements Serializable {
	private static final long serialVersionUID = -7309192366657239764L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private int id;

	@Column( name = "title")
	@Type(type="text")
	private String title;

	@Column(name = "artist")
	private Artist artist;

	@Column(name = "audio")
	private String audio;
	

	public Track() {

	}
	public Track(String title) {
		this.title = title;
		this.artist = null;
		this.audio = null;
	}

	public Track(String title, Artist artist, String audio) {
		super();
		this.title = title;
		this.artist = artist;
		this.audio = audio;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}


	public String getAudio() {
		return audio;
	}


	public void setAudio(String audio) {
		this.audio = audio;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", title=" + title + ", artist=" + artist + ", audio=" + audio + "]";
	}
	

}