package br.com.socialeduk.socialeduk.Repositories;

import br.com.socialeduk.socialeduk.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    User getUserById(Long id);

}
