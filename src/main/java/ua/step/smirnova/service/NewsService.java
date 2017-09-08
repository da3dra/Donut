package ua.step.smirnova.service;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.News;

public interface NewsService {
	public void save(News n);
	public void newAlbum(Artist artist, Album album);
	void edit(News n);
}
