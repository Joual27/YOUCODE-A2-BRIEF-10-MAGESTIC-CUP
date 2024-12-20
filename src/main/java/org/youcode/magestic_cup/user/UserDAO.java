package org.youcode.magestic_cup.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends MongoRepository<User , String> {
    @Query("{ username : ?0 }")
    Optional<User> findByUsername(String username);
}
