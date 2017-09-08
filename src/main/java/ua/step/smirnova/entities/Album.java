package ua.step.smirnova.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "albums")
public class Album implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int id;

	@Column
	@Type(type = "text")
	private String title;

	@ManyToMany(mappedBy = "albums")
	private Set<Artist> artists;

	@ManyToMany
	private Set<Track> tracks;

	@ManyToMany
	@JoinTable(name = "ALBUMS_GENRES", joinColumns = @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID"))
	private Set<Genre> genres;
	
	@ManyToMany
	@JoinTable(name = "ALBUMS_STORES", joinColumns = @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "STORE_ID", referencedColumnName = "ID"))
	private Set<Store> stores;

	@Column
	private Double price;
	
	@Column
	private AlbumStatus status;
	
	@Column
	@Type(type = "text")
	private String cover;

	@Column
	private String tags;
	
	@Column
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date date;

	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
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

	public void addGenre(Genre g) {
		genres.add(g);
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public AlbumStatus getStatus() {
		return status;
	}

	public void setStatus(AlbumStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", artists=" + artists + ", tracks=" + tracks + ", genres="
				+ genres + ", tags=" + tags + "]";
	}
	public enum AlbumStatus{
		UNCHECKED, APPROVED, BANNED
	}
}
