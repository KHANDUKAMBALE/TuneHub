package tunehubproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunehubproject.entity.users;
import tunehubproject.repositories.usersrepository;
@Service
public  class usersserviceimplementation implements usersservices {
@Autowired
usersrepository repo;
	

	@Override
	public String adduser(users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return "user added successfully";

	}


	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public boolean validateuser(String email,String password) {
		users user=repo.findByEmail(email);
		String db_pass =user.getPassword();
		if(password.equals(db_pass)) {
			return true;
		}
		else
		{
			return false;
		}
	}



	@Override
	public String getRole(String email) {
		users user=repo.findByEmail(email);
		return user.getRole();
	}


	@Override
	public users getuser(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateuser(users user) {
		repo.save(user);
		
	}


	
	
	}
