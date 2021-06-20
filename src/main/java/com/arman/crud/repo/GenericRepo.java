package com.arman.crud.repo;

import java.util.List;

public interface GenericRepo<T> {
    T getById(Integer id);
    List<T> getAll();
    T save(T object);
    T update(T object);
    void deleteById(Integer id);
}
