package org.youcode.magestic_cup.round;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundDAO extends MongoRepository<Round , String> {
}
