package Patrones.Dao;


import java.util.List;

public interface Dao<T>{
    void insert(T objet);
    void update(T objet);
    void delete(T objet);
    void deleteByID(int id);
    T get(int id);
    List<T> getAll();
}
