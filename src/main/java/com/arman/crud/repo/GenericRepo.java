package com.arman.crud.repo;

import java.util.List;

public interface GenericRepo<T> {
    List<T> readFile();
    void writeFile(List<T> list);
    T getById(Integer id);
    List<T> getAll();
    T save(T object);
    T update(T object);
    void deleteById(Integer id);
}
