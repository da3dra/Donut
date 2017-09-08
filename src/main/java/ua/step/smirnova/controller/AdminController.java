package ua.step.smirnova.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Album.AlbumStatus;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.Status;
import ua.step.smirnova.service.AlbumService;
import ua.step.smirnova.service.ArtistService;

@Controller
public class AdminController {

	private ArtistService artistService;
	private AlbumService albumService;

	@Autowired(required = true)
	public void setAuthorService(ArtistService artistService, AlbumService albumService) {
		this.artistService = artistService;
		this.albumService = albumService;
	}

	@PostMapping("admin/approve/artist/{id}/album/{album_id}")
	public ResponseEntity<?> approveAlbum(@PathVariable int id, @PathVariable int album_id) {
		Album album = albumService.get(album_id);
		album.setStatus(AlbumStatus.APPROVED);
		albumService.edit(album);
		Artist artist = artistService.get(id);
		if (artistService.checkAllApproved(id) && artist.getStatus().equals(Status.HAS_UNCHECKED_CONTENT)) {
			artist.setStatus(Status.REGULAR);
			artistService.edit(artist);
		}
		return ResponseEntity.ok(id);
	}

	@PostMapping("admin/ban/artist/{id}/album/{album_id}")
	public ResponseEntity<?> banAlbum(@PathVariable int id, @PathVariable int album_id) {
		Album album = albumService.get(album_id);
		album.setStatus(AlbumStatus.BANNED);
		albumService.edit(album);
		Artist artist = artistService.get(id);
		artist.setStatus(Status.COPYRIGHT_BAN);
		artistService.edit(artist);
		return ResponseEntity.ok(id);
	}
	
	@GetMapping("admin/statuses")
	public ResponseEntity<?>  getStatuses(){
		return ResponseEntity.ok(EnumSet.allOf(Status.class));
	}
	
	@PostMapping("admin/artist/{id}/status/{status}")
	public ResponseEntity<?> banAlbum(@PathVariable int id, @PathVariable Status status) {
		System.err.println(status);
		Artist artist = artistService.get(id);
		artist.setStatus(status);
		artistService.edit(artist);
		return ResponseEntity.ok(id);
	}
	
}
