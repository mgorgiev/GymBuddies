package mk.com.gymbuddies.gymbuddy.repository;

import mk.com.gymbuddies.gymbuddy.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);
    Optional<UserEntity>findByUsernameAndPassword(String user,String password);

    // You can add more custom queries here if needed
}