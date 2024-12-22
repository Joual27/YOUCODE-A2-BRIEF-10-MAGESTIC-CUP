package org.youcode.magestic_cup.match;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchDAO extends MongoRepository<Match , String> {
    List<Match> findByRoundId(String roundId);
}
