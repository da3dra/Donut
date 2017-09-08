package ua.step.smirnova.service;

import org.springframework.web.multipart.MultipartFile;

public interface MediaService {
	
	public static final String audioPath = "D:/Donut/resources/audio";
	public static final String coverPath = "D:/Donut/resources/covers";
	
	public String upload(MultipartFile file, int artist_id, int album_id);
	
}
