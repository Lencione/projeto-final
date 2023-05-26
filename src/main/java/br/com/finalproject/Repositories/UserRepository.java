package br.com.finalproject.Repositories;

import br.com.finalproject.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    User getUserById(Long id);

}
