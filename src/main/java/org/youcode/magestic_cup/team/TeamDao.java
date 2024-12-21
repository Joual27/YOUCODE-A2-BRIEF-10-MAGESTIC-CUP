package org.youcode.magestic_cup.team;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends MongoRepository<Team , String> {
}
