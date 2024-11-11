package com.revolut.account.exceptions;

public class InsufficientAmountException extends Exception {

    public InsufficientAmountException(String message) {
        super(message);
    }
}
