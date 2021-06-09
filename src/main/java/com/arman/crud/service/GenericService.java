package com.arman.crud.service;

import java.util.List;

public interface GenericService<T> {
    T getById(Integer id);

    void deleteById(Integer id);

    List<T> getAll();
}
