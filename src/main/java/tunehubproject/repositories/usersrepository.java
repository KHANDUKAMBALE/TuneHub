package tunehubproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tunehubproject.entity.users;

public interface usersrepository extends JpaRepository<users,Integer> {
public users findByEmail(String email);
}
