package tunehubproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import tunehubproject.entity.users;
import tunehubproject.services.usersservices;

@Controller
public class userscontroller
{
	@Autowired
	usersservices service ;

	@PostMapping("/register")
	public String adduser(@ModelAttribute users user) {
		boolean userstatus=service.emailExists(user.getEmail());
		if(userstatus==false) {
			service.adduser(user);
			System.out.println("User added");
		}
		else {
			System.out.println("User already exists");
		}

		return "home";
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password 
			,HttpSession session) {
		if(service.validateuser(email, password)==true) {
			String role=service.getRole(email);

			session.setAttribute("email",email);

			if(role.equals("admin")) {
				return "adminhome";
			}
			else {
				return "customerhome";
			}
		}
		else {
			return "login";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"logout";

	}

}

