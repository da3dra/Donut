package ua.step.smirnova.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TrackController {
	@GetMapping(value = "track")
	public ResponseEntity<String> getList() throws IOException {
		//File convFile = new File("D:/Donut/resources/audio/audio.mp3");
		Path path = Paths.get("D:/Donut/resources/audio/audio.mp3");
		byte[] data = Files.readAllBytes(path);
		byte[] encoded = Base64.encodeBase64(data);
		String track = new String(encoded);
		return ResponseEntity.ok(track);
	}
}
