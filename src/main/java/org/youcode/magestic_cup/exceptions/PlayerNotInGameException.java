package org.youcode.magestic_cup.exceptions;

public class PlayerNotInGameException extends RuntimeException {
    public PlayerNotInGameException(String message) {
        super(message);
    }
}
