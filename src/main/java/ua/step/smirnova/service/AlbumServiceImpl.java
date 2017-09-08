package ua.step.smirnova.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.net.SyslogOutputStream;
import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Album.AlbumStatus;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.Genre;
import ua.step.smirnova.jsonwrappers.AlbumDTO;
import ua.step.smirnova.repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	private GenreService genreService;
	private ArtistService artistService;
	private ModelMapper modelMapper;

	@Autowired(required = true)
	public void setBookService(GenreService genreService, ModelMapper modelMapper, ArtistService artistService) {
		this.genreService = genreService;
		this.modelMapper = modelMapper;
		this.artistService = artistService;
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
		Album a = this.get(id);
		List<Artist> artists = artistService.findAllByAlbum(a);
		artists.forEach(artist -> artist.getAlbums().remove(a));
		artists.forEach(artist -> artistService.edit(artist));
		albumRepository.delete(id);
	}

	@Override
	@Transactional
	public Album get(Integer id) {
		return albumRepository.findOne(id);
	}

	@Override
	@Transactional
	public List<Album> findAllByTitle(String title) {
		return albumRepository.findByTitleIgnoreCaseContaining(title);
	}

	public List<Genre> getAllByGenreId(int id) {
		Genre g = genreService.get(id);
		Set<Genre> genres = new HashSet<>();
		genres.add(g);
		return albumRepository.findAllByGenres(genres);
	}

	@Override
	public List<Album> findAllByArtist(int id) {
		return albumRepository.findByArtistsId(id);
	}

	public AlbumDTO convertToDto(Album album) {
		AlbumDTO albumDTO = modelMapper.map(album, AlbumDTO.class);
		List<String> allGenres = album.getGenres().stream().map(genre -> genre.getTitle()).collect(Collectors.toList());
		String genres = allGenres.toString();
		albumDTO.setGenres(genres.substring(1, genres.length() - 1));
		return albumDTO;
	}

	public Set<Genre> extractGenres(String list) {
		StringTokenizer st = new StringTokenizer(list, " ,;");
		Set<Genre> genres = new HashSet<>();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			Genre genre = genreService.getByTitle(token);
			if (genre == null) {
				genre = new Genre(token);
				genreService.add(genre);
			}
			genres.add(genre);
		}
		return genres;
	}

	@Override
	public Page<Album> getPage(PageRequest pageRequest) {
		return albumRepository.findAll(pageRequest);
	}

	@Override
	public List<Album> findByArtistsIdAndStatus(int id, AlbumStatus status) {
		return albumRepository.findByArtistsIdAndStatus(id, status);
	}
}
