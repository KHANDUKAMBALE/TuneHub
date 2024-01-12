package tunehubproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunehubproject.entity.playlist;
import tunehubproject.repositories.playlistrepository;

@Service
public  class playlistserviceimplementation implements playlistservice {

	@Autowired
	playlistrepository repo;
	@Override
	public void addplaylist(playlist Playlist) {
		repo.save(Playlist);
		
	}
	@Override
	public List<playlist> fetchAllPlaylist() {
		return repo.findAll();
		
	}
	
}
