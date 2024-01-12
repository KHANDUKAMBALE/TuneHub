package tunehubproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunehubproject.entity.song;
import tunehubproject.repositories.songrepository;

@Service
public class songserviceimplementation implements songservice {

	@Autowired
	songrepository repo;
	@Override
	public void addsong(song Song) {
		repo.save(Song);
		
	}
	@Override
	public List<song> fetchAllSong() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public boolean songExists(String name) {
		song Song= repo.findByName(name);
		if(Song==null) {
			return false;
		}
		else {
			return true;
		}

	}
	@Override
	public void updatesong(song Song) {
		// TODO Auto-generated method stub
		repo.save(Song);
	}
	
}
