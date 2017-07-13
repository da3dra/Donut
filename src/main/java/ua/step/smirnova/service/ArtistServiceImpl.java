package ua.step.smirnova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.repository.AlbumRepository;
import ua.step.smirnova.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements GenericService<Artist, Integer> {
	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public Artist add(Artist entity) {
		Artist a = entity;
		System.err.println(entity);
		return artistRepository.saveAndFlush(a);

	}

	@Override
	@Transactional
	public Artist edit(Artist entity) {
		return artistRepository.saveAndFlush(entity);
	}

	@Override
	@Transactional
	public List<Artist> getAll() {
		return artistRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		artistRepository.delete(id);
	}

	@Override
	@Transactional
	public Artist get(Integer id) {
		return artistRepository.findOne(id);
	}

}
