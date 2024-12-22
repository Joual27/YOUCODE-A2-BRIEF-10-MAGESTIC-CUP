package org.youcode.magestic_cup.exceptions;

public class TeamStatsLimitExceededException extends RuntimeException {
    public TeamStatsLimitExceededException(String message) {
        super(message);
    }
}
