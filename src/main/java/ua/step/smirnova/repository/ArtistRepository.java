package ua.step.smirnova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Artist;

public interface ArtistRepository  extends JpaRepository<Artist, Integer>{

	List<Artist> findByAlbumsContaining(Album a);

	List<Artist> findByUsernameIgnoreCaseContaining(String item);
	
	Artist findByUsername(String username);

}
