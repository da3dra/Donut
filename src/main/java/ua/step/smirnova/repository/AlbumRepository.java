package ua.step.smirnova.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Genre;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

	List<Genre> findAllByGenres(Set<Genre> g);

	Page<Album> findAll(Pageable pageable);
}
