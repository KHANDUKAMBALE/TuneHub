package tunehubproject.services;

import tunehubproject.entity.users;

public interface usersservices {
public  String adduser(users user);
public boolean emailExists(String email);
public boolean validateuser(String email,String password);
// predefined user class is present in java 
public String getRole(String email);
public  users getuser(String email);
public void updateuser(users user);
}
