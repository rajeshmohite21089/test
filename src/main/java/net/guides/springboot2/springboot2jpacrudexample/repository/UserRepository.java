package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import net.guides.springboot2.springboot2jpacrudexample.model.User;
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query("SELECT u from User u where u.username=:username")
	public User getUserByUsername(@Param("username") String username);

}
