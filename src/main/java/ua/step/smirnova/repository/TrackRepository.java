package ua.step.smirnova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.smirnova.entities.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {
	Iterable<Track> findAllByOrderById();
}
