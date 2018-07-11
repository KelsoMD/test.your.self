package by.nesterenok.testyourself.dao;

import by.nesterenok.testyourself.domain.Entity;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;

import java.util.List;

public interface BaseDao<T extends Entity> {

    void create(T t);

    T read(int id);

    void update(T t);

    void delete(T t);

    List<T> readAll();

}
