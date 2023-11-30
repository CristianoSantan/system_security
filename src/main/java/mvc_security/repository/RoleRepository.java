package mvc_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mvc_security.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
