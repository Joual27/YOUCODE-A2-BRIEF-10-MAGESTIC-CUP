package org.youcode.magestic_cup.exceptions;

public class StatsLimitExceededException extends RuntimeException {
    public StatsLimitExceededException(String message) {
        super(message);
    }
}
