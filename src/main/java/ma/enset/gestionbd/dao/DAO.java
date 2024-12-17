package ma.enset.gestionbd.dao;

import java.util.List;

public interface DAO<T,E> {
    public List<T> findAll();
    public T findById(E id);
    public void save(T t);
    public void update(T t);
    public boolean deleteById(E id);
}
