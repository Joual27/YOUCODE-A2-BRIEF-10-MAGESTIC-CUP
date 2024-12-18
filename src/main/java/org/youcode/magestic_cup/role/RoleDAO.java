package org.youcode.magestic_cup.role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends MongoRepository<Role ,String> {

    @Query("{roleName :  ?0}")
    boolean existsByRoleName(String roleName);
}
