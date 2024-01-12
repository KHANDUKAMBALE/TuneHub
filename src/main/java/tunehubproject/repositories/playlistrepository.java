package tunehubproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tunehubproject.entity.playlist;

public interface playlistrepository extends JpaRepository<playlist,Integer>
{

	
}
