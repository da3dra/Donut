package ua.step.smirnova.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "tracks")
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int id;

	@Column
	private String title;

	@Column
	@Type(type = "text")
	private String audio;

	public void setId(int id) {
		this.id = id;
	}

	public Track() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "Track [id=" + id + ", title=" + title +"]";
	}

}