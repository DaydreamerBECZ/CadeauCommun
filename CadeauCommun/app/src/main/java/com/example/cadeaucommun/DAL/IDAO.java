package com.example.cadeaucommun.DAL;

import java.util.List;

public interface IDAO<T> {
    public void add(T t);
    public T findOne(int id);
    public List<T> findAll();
    public void update(T t);
    public void deleteById(int id);

}
