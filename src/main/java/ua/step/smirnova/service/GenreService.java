package ua.step.smirnova.service;

import java.util.List;

import ua.step.smirnova.entities.Genre;

public interface GenreService {
	Genre add(Genre entity);

	Genre edit(Genre entity);

	List<Genre> getAll();

	void delete(Integer id);

	public Genre get(Integer id);

	Genre getByTitle(String title);
}
