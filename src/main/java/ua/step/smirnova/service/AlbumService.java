package ua.step.smirnova.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Album.AlbumStatus;
import ua.step.smirnova.entities.Genre;
import ua.step.smirnova.jsonwrappers.AlbumDTO;

public interface AlbumService {
	Album add(Album entity);

	Album edit(Album entity);

	List<Album> getAll();

	void delete(Integer id);

	public Album get(Integer id);

	List<Album> findAllByTitle(String title);

	List<Album> findAllByArtist(int id);
	
	List<Album> findByArtistsIdAndStatus(int id, AlbumStatus status);

	Set<Genre> extractGenres(String parameter);

	AlbumDTO convertToDto(Album album);

	Page<Album> getPage(PageRequest pageRequest);
	
	
}
