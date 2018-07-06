package com.wossha.auth.models.repository;

import org.springframework.stereotype.Service;

@Service
public interface Repository<T> {

    String add(T entity);

    String remove(T entity);

    T update(T entity);

}