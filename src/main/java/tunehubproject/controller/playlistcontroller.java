package tunehubproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tunehubproject.entity.playlist;
import tunehubproject.entity.song;
import tunehubproject.services.playlistservice;
import tunehubproject.services.songservice;

@Controller
public class playlistcontroller {
	@Autowired
	songservice songserv;

	@Autowired
	playlistservice Playlistservice;
	@GetMapping("/createplaylist")
	public String createplaylist(Model model)
	{

		List<song>songlist=songserv.fetchAllSong();
		model.addAttribute("songs",songlist);
		return "createplaylist";	
	}


	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute playlist Playlist)
	{

		Playlistservice.addplaylist(Playlist);
		List<song>songlist=Playlist.getSongs();
		for(song s: songlist) {
			s.getPlaylists().add(Playlist);
			songserv.updatesong(s);
		}
		return "adminhome";	
	}
	@GetMapping("/viewplaylist")
	public String viewplaylist(Model model) {
		List<playlist> allPlaylists=Playlistservice.fetchAllPlaylist();
		model.addAttribute("allPlaylists",allPlaylists);
		return "displayplaylist";
	}


}
