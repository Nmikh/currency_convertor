package com.exceptions;

public class CurrencyException extends Exception {
    public CurrencyException() { super(); }
    public CurrencyException(String message) { super(message); }
    public CurrencyException(String message, Throwable cause) { super(message, cause); }
    public CurrencyException(Throwable cause) { super(cause); }
}
