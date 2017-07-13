package ua.step.smirnova.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Genre;
import ua.step.smirnova.repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements GenericService<Album, Integer> {
	
	@Autowired
	private AlbumRepository albumRepository;
	private GenreServiceImpl genreService;

	@Autowired(required = true)
	public void setBookService(GenreServiceImpl genreService) {
		this.genreService = genreService;
	}

	@Override
	@Transactional
	public Album add(Album entity) {
		Album a = entity;
		return albumRepository.saveAndFlush(a);
	}

	@Override
	@Transactional
	public Album edit(Album entity) {
		return albumRepository.saveAndFlush(entity);
	}

	@Override
	@Transactional
	public List<Album> getAll() {
		return albumRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		albumRepository.delete(id);
	}

	@Override
	@Transactional
	public Album get(Integer id) {
		return albumRepository.findOne(id);
	}

	public List<Genre> getAllByGenreId(int id) {
		Genre g = genreService.get(id);
		Set<Genre> genres = new HashSet<>();
		genres.add(g);
		return albumRepository.findAllByGenres(genres);
	}

}
