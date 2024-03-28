package com.mm.surrealdb.exception;

public class MissingSurrealTableAnnotationException extends SurrealSpringException {
    private final Class<?> entityType;

    public MissingSurrealTableAnnotationException(Class<?> entityType) {
        super("Missing @SurrealTable annotation on " + entityType.getName());
        this.entityType = entityType;
    }

    public Class<?> getEntityType() {
        return entityType;
    }
}
