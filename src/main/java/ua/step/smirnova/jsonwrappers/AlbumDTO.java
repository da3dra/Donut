package ua.step.smirnova.jsonwrappers;

import java.util.Set;

import ua.step.smirnova.entities.Album.AlbumStatus;
import ua.step.smirnova.entities.Track;

public class AlbumDTO {
	private int id;
	private String title;
	private String cover;
	private String genres;
	private AlbumStatus status;
	private String tags;
	private Set<Track> tracks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	public AlbumStatus getStatus() {
		return status;
	}

	public void setStatus(AlbumStatus status) {
		this.status = status;
	}

}
