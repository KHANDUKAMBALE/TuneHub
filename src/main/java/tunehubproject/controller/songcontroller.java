package tunehubproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tunehubproject.entity.song;
import tunehubproject.services.songservice;

@Controller
public class songcontroller {
	@Autowired 
	songservice service;
@PostMapping("/addsong")
public String addsong(@ModelAttribute song Song) {
	boolean songstatus=service.songExists(Song.getName());
	if(songstatus==false) {
		
service.addsong(Song);
System.out.println("Song added successfully");
	}
	else {
		System.out.println("Song already exixts");
	}
	return "adminhome";
}

@GetMapping("/viewsong")
public String viewsong(Model model) {

model.addAttribute("song",service.fetchAllSong());
return "displaysongs";
	
}
@GetMapping("/playsong")
public String playsong(Model model) {
boolean premiumuser=false; // only this an be changed to true/false
if(premiumuser==true) { //can't change conditions  // if premiumuser =false then it shows in web as make payment
	List<song> songlist=service.fetchAllSong();
	model.addAttribute("song",songlist);
	return "displaysongs";
}
else {
return "makepayment";
}	
}
}
