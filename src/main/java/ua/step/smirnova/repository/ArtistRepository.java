package ua.step.smirnova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.smirnova.entities.Artist;

public interface ArtistRepository  extends JpaRepository<Artist, Integer>{

}
