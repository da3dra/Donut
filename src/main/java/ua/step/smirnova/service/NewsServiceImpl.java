package ua.step.smirnova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.News;
import ua.step.smirnova.repository.NewsRepository;
import ua.step.smirnova.validators.UserCreateFormValidator;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepository newsRepository;
	private UserService userService;
	private  ArtistService artistService;

	@Autowired
	public NewsServiceImpl(UserService userService,ArtistService artistService) {
		this.userService = userService;
		this.artistService = artistService;
	}

	@Override
	public void save(News n) {
		News news = new News();
		news = n;
		newsRepository.save(news);
	}

	@Override
	public void edit(News n) {
		newsRepository.save(n);
	}

	@Override
	public void newAlbum(Artist artist, Album album) {
		News news = new News();
		news.setTitle(artist.getUsername() + " added new album - ");
		news.setImage(album.getCover());
		news.setContent_link("album?id=" + album.getId());
		newsRepository.save(news);
		//System.err.println(artist.getFollowers().toString());
		artist.getFollowers().forEach(follower -> follower.getNews().add(news));
		artist.getFollowers().forEach(follower -> userService.update(follower));
		artist.getFollowers().forEach(follower -> System.err.println(follower.getNews().toString()));
	}

}
