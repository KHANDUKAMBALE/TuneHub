package tunehubproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tunehubproject.entity.song;

@Service
public interface songservice {

public void addsong(song Song);

public void updatesong(song Song) ;

public List<song> fetchAllSong();

public boolean songExists(String name);







}
