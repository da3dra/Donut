package ua.step.smirnova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.step.smirnova.entities.Track;
import ua.step.smirnova.repository.TrackRepository;

@Service
public class TrackServiceImpl implements TrackService {


		@Autowired  
		private TrackRepository trackRepository; 

		@Override
		@Transactional
		public Track add(Track track) {
			Track t = track; 
			return trackRepository.saveAndFlush(t);
		}

		@Override
		@Transactional
		public void delete(int id) {
			trackRepository.delete(id);
		}

		@Override
		@Transactional
		public Track editTrack(Track t) {
			return trackRepository.saveAndFlush(t);
		}

		@Override
		@Transactional
		public List<Track> getAll() {
			return trackRepository.findAll();
		}
	}



