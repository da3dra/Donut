package ua.step.smirnova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.Album.AlbumStatus;
import ua.step.smirnova.repository.AlbumRepository;
import ua.step.smirnova.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {
	@Autowired
	private ArtistRepository artistRepository;

	private AlbumService albumService;

	@Autowired(required = true)
	public void setAuthorService(AlbumService albumService) {
		this.albumService = albumService;
	}

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

	@Override
	public List<Artist> findAllByAlbum(Album a) {
		return artistRepository.findByAlbumsContaining(a);
	}

	public List<Artist> findAllByName(String item) {
		return artistRepository.findByUsernameIgnoreCaseContaining(item);
	}

	@Override
	public Artist findByUsername(String username) {
		return artistRepository.findByUsername(username);
	}

	@Override
	public boolean checkAllApproved(int id) {
		List<Album> unchecked = albumService.findByArtistsIdAndStatus(id, AlbumStatus.UNCHECKED);
		List<Album> banned = albumService.findByArtistsIdAndStatus(id, AlbumStatus.BANNED);
		if (unchecked.isEmpty() && banned.isEmpty()) {
			System.err.println("ALL APPROVED");
			return true;
		}
		return false;
	}

}
