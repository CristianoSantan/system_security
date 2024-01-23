package mvc_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mvc_security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    
    User findById(long id);

}
