package org.youcode.magestic_cup.exceptions;

public class InvalidPlayersNumberException extends RuntimeException {
    public InvalidPlayersNumberException(String message) {
        super(message);
    }
}