package ua.step.smirnova.service;

import java.util.List;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Artist;

public interface ArtistService {
	Artist add(Artist entity);

	Artist edit(Artist entity);

	List<Artist> getAll();

	void delete(Integer id);

	public Artist get(Integer id);

	List<Artist> findAllByAlbum(Album a);
	
	Artist findByUsername(String username);

	boolean checkAllApproved(int id);

}
