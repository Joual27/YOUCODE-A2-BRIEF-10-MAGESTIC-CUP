package org.youcode.magestic_cup.stats;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsDAO extends MongoRepository<Stats, String> {
    List<Stats> findByPlayerId(String playerId);
}