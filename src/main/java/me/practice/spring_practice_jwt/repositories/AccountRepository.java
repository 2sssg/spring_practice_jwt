package me.practice.spring_practice_jwt.repositories;


import java.util.Optional;
import me.practice.spring_practice_jwt.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	Optional<Account> findByUsername(String username);
}
