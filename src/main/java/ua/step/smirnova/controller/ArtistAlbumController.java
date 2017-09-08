package ua.step.smirnova.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Album.AlbumStatus;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.Genre;
import ua.step.smirnova.entities.Status;
import ua.step.smirnova.entities.Track;
import ua.step.smirnova.jsonwrappers.AlbumDTO;
import ua.step.smirnova.service.AlbumService;
import ua.step.smirnova.service.ArtistService;
import ua.step.smirnova.service.TrackService;
import ua.step.smirnova.service.NewsService;

@Controller
public class ArtistAlbumController {

	private ArtistService artistService;
	private AlbumService albumService;
	private TrackService trackService;
	private NewsService newsService;

	@Autowired(required = true)
	public void setAuthorService(ArtistService artistService, AlbumService albumService, TrackService trackService,
			NewsService newsService) {
		this.artistService = artistService;
		this.albumService = albumService;
		this.trackService = trackService;
		this.newsService = newsService;
	}

	@PostMapping("/artist/{id}/album/{album_id}")
	public ResponseEntity<?> postAlbum(@PathVariable int id, @PathVariable int album_id,
			MultipartHttpServletRequest request) throws IOException {
		Album album = albumService.get(album_id);
		Artist artist = artistService.get(id);
		if (album == null) {
			album = new Album();
			albumService.add(album);
			Set<Artist> artists = new HashSet<>();
			Set<Track> tracks = new HashSet<>();
			Set<Genre> genres = new HashSet<>();
			album.setArtists(artists);
			album.setTracks(tracks);
			album.setGenres(genres);
			album.setStatus(AlbumStatus.UNCHECKED);
			artist.setStatus(Status.HAS_UNCHECKED_CONTENT);
			albumService.edit(album);
		}
		Iterator<String> itr = request.getFileNames();
		int i = 1;
		while (itr.hasNext()) {
			MultipartFile mpf = request.getFile(itr.next());
			byte[] file = mpf.getBytes();
			byte[] encoded = Base64.encodeBase64(file);
			String encodedString = new String(encoded);
			if (i == 1) {
				album.setCover(encodedString);
			} else {
				Track track = new Track();
				trackService.add(track);
				track.setTitle(mpf.getName());
				track.setAudio(encodedString);
				trackService.editTrack(track);
				System.err.println("get tr "+album);
				album.getTracks().add(track);
				albumService.edit(album);
			}
			i+=1;
		}
		album.setTitle(request.getParameter("title"));
		Set<Genre> genres = albumService.extractGenres(request.getParameter("genres"));
		album.setGenres(genres);
		album.setTags(request.getParameter("tags"));
		album.addArtist(artist);
		album.setStatus(AlbumStatus.UNCHECKED);
		albumService.edit(album);
		System.err.println(album);
		artist.addAlbum(album);
		artist.setStatus(Status.HAS_UNCHECKED_CONTENT);
		artistService.edit(artist);
		newsService.newAlbum(artist, album);
		return ResponseEntity.ok(id);
	}

	@GetMapping("/artist/{id}/albums")
	public ResponseEntity<?> getAlbumList(@PathVariable int id) {
		List<AlbumDTO> dtoList = albumService.findAllByArtist(id).stream()
				.map(album -> albumService.convertToDto(album)).collect(Collectors.toList());
		return ResponseEntity.ok(dtoList);
	}

	@DeleteMapping("/artist/album/{id}")
	public ResponseEntity<?> deleteAlbum(@PathVariable int id) {
		albumService.delete(id);
		return ResponseEntity.ok(id);
	}

	@GetMapping("/artist/album/{id}")
	public ResponseEntity<?> getAlbum(@PathVariable int id) {
		Album album = albumService.get(id);
		AlbumDTO dto = albumService.convertToDto(album);
		return ResponseEntity.ok(dto);
	}

}
