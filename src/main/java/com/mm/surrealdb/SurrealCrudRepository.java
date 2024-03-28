package com.mm.surrealdb;

import java.util.List;
import java.util.Optional;

public interface SurrealCrudRepository<T, ID> {
    Optional<T> findById(ID id);
    List<T> findAll();
    T save(T entity);
    void delete(T entity);
    T update(T entity);
}
