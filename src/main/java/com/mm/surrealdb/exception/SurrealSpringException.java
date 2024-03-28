package com.mm.surrealdb.exception;

/**
 * Baseline exception in the db driver
 */
public class SurrealSpringException extends RuntimeException {
    public SurrealSpringException(String message) {
        super(message);
    }
}
