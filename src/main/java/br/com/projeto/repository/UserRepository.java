package br.com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projeto.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u where u.name = ?1")
	User findByNameQuery(String name);

}
