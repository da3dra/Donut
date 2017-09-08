package ua.step.smirnova;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.Genre;
import ua.step.smirnova.entities.Role;
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
		
	/*	File convFile = new File("D:/Donut/resources/audio");
		convFile.mkdir();*/
		
		//convFile.createNewFile();
	/*	FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();*/
		
	/*	Artist art = artistService.get(1);
		Album album = new Album();
		album.setTitle("TEST 2");
		albumService.add(album);
		System.err.println(art);
		art.addAlbum(album);
		artistService.edit(art);
		System.err.println(art.getAlbums());*/
		
		
		/*
		 * for(int i=0;i<5;i++){ Genre g = new Genre(); g.setTitle("genre"+i);
		 * genreService.add(g); Album al = new Album(); al.setTitle("album"+i);
		 * Album al2 = new Album(); al2.setTitle("album"+i+" "+i); Set<Genre>
		 * gns = new HashSet<>(); al.setGenres(gns); al2.setGenres(gns);
		 * Set<Album> albs = new HashSet<>(); albumService.add(al);
		 * albumService.add(al2); }
		 * 
		 * System.err.println("getting artist"+ar); // Artist ar2 =
		 * artistService.get(16); //Genre g = genreService.get(3); //Genre g2 =
		 * genreService.get(9); // Genre g2 = new Genre(); //
		 * g.setTitle("Country"); // g2.setTitle("Techno"); //
		 * genreService.add(g2); // genreService.add(g); Album a = new Album();
		 * //ar.addAlbum(a); //artistService.edit(ar);
		 * a.setTitle("Dangerous Stuff"); a.setCover("covers/15.jpg");
		 * a.addArtist(ar); // a.addArtist(ar2); //a.addGenre(g); //
		 * a.addGenre(g2); albumService.add(a); System.err.println(a);
		 */
	}
}
