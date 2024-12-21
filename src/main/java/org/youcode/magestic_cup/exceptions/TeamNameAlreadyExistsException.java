package org.youcode.magestic_cup.exceptions;

public class TeamNameAlreadyExistsException extends RuntimeException {
    public TeamNameAlreadyExistsException(String message) {
        super(message);
    }
}
