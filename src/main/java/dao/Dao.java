package dao;

import java.util.ArrayList;

public interface Dao<T> {
    ArrayList<T> getAll();
    void insert(T entity);
    T getById(int id);
    void delete(T entity);
    void update(T entity);
    void truncate();
}
