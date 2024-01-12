package tunehubproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tunehubproject.entity.song;

public interface songrepository extends JpaRepository<song, Integer> {


	public song findByName(String name);

	

}
