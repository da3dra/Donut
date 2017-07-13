package ua.step.smirnova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.smirnova.entities.Genre;
import ua.step.smirnova.entities.Track;

public interface GenreRepository  extends JpaRepository<Genre, Integer>{

}
