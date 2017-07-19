package ua.step.smirnova;

import java.io.File;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.Genre;
import ua.step.smirnova.repository.AlbumRepository;
import ua.step.smirnova.repository.ArtistRepository;
import ua.step.smirnova.repository.GenreRepository;
import ua.step.smirnova.service.AlbumServiceImpl;
import ua.step.smirnova.service.ArtistServiceImpl;
import ua.step.smirnova.service.GenreServiceImpl;

// Класс для заполнения БД объектами
@Component
public class DataLoader implements ApplicationRunner {

	private ArtistServiceImpl artistService;
	private AlbumServiceImpl albumService;
	private GenreServiceImpl genreService;

	@Autowired
	public DataLoader(AlbumServiceImpl albumService, ArtistServiceImpl artistService, GenreServiceImpl genreService) {
		this.albumService = albumService;
		this.artistService = artistService;
		this.genreService = genreService;
	}

	@Transactional
	public void run(ApplicationArguments args) throws Exception {
/*		Artist ar = artistService.get(4);
		System.err.println("getting artist"+ar);
		// Artist ar2 = artistService.get(16);
		//Genre g = genreService.get(3);
		//Genre g2 = genreService.get(9);
		// Genre g2 = new Genre();
		// g.setTitle("Country");
		// g2.setTitle("Techno");
		// genreService.add(g2);
		// genreService.add(g);
		Album a = new Album();
		//ar.addAlbum(a);
		//artistService.edit(ar);
		a.setTitle("Dangerous Stuff");
		a.setCover("covers/15.jpg");
		a.addArtist(ar);
		// a.addArtist(ar2);
		//a.addGenre(g);
		// a.addGenre(g2);
		albumService.add(a);
		System.err.println(a);*/
	}
}
