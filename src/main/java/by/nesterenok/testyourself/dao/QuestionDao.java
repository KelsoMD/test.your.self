package by.nesterenok.testyourself.dao;

import by.nesterenok.testyourself.domain.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends CrudRepository<Question, Integer> {
}
