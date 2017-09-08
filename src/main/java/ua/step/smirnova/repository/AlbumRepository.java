package ua.step.smirnova.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Album.AlbumStatus;
import ua.step.smirnova.entities.Genre;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
	
	List<Album> findByArtistsId(int id);
	
	List<Album> findByArtistsIdAndStatus(int id, AlbumStatus status);

	List<Genre> findAllByGenres(Set<Genre> g);

	Page<Album> findAll(Pageable pageable);

	List<Album> findByTitleIgnoreCaseContaining(String title);
	
/*	List<Book> findAllByGenres(@Param("genres")Set<Genre> genres);*/
}
