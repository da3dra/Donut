package ua.step.smirnova.service;

import java.util.List;

import ua.step.smirnova.entities.Track;

public interface TrackService {
	Track add(Track track);

	Track editTrack(Track track);

	List<Track> getAll();

	void delete(int id);
}
