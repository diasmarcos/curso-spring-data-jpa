package br.com.microness.repository;
import br.com.microness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameContaining(String name);

    User findByUsername(String username);

    //Query override
    @Query("SELECT u FROM tb_user WHERE u.name LIKE %:name%")
    List<User> filtrarPorNome(@Param("name") String name);

}
