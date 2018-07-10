package by.nesterenok.testyourself.dao;

import by.nesterenok.testyourself.domain.Result;

public interface ResultDao extends BaseDao<Result> {

    long counter();
}
