package ua.step.smirnova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.step.smirnova.entities.Genre;
import ua.step.smirnova.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenericService<Genre, Integer> {
	@Autowired 
	GenreRepository genreRepository;
	
	@Override
	public Genre add(Genre entity) {
		Genre g = entity;
		return genreRepository.saveAndFlush(g);
	}

	@Override
	@Transactional
	public Genre edit(Genre entity) {
		return genreRepository.saveAndFlush(entity); 
	}

	@Override
	@Transactional
	public List<Genre> getAll() {
		return genreRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		genreRepository.delete(id);
	}

	@Override
	@Transactional
	public Genre get(Integer id) {
		return genreRepository.findOne(id);
	}

}
