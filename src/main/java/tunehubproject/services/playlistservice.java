package tunehubproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tunehubproject.entity.playlist;
@Service
public interface playlistservice  {

	public   void addplaylist(playlist Playlist);

	

	public List<playlist> fetchAllPlaylist();
	

}
