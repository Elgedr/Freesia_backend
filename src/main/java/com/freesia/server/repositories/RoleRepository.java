package com.freesia.server.repositories;

import java.util.Optional;

import com.freesia.server.models.ERole;
import com.freesia.server.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
