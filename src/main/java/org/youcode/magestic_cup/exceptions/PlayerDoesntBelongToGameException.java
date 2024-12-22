package org.youcode.magestic_cup.exceptions;

public class PlayerDoesntBelongToGameException extends RuntimeException {
    public PlayerDoesntBelongToGameException(String message) {
        super(message);
    }
}
