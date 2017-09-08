package ua.step.smirnova.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MediaServiceImpl implements MediaService {

	@Override
	public String upload(MultipartFile file, int artist_id, int album_id) {
		String path = MediaService.coverPath + "/" + artist_id + "/" + album_id;
		File dir = new File(path);
		try {
			dir.mkdirs();
			File newFile = new File(path, file.getOriginalFilename());
			path = path + file.getOriginalFilename();
			FileOutputStream fos;
			fos = new FileOutputStream(newFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
