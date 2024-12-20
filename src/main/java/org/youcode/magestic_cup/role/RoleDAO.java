package org.youcode.magestic_cup.role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDAO extends MongoRepository<Role ,String> {
    boolean existsByRoleName(String roleName);
    Optional<Role> findByRoleName(String roleName);
}
