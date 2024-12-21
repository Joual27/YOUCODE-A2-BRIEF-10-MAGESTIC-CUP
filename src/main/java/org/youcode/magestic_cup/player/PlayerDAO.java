package org.youcode.magestic_cup.player;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDAO extends MongoRepository<Player , String > {
}
