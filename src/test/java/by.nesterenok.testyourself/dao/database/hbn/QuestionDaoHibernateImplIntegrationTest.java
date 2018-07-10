package by.nesterenok.testyourself.dao.database.hbn;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import by.nesterenok.testyourself.spring.configuration.DaoConfig;
import by.nesterenok.testyourself.spring.configuration.PersistenceContext;

@ExtendWith(SpringExtension.class)
@Transactional
@ContextConfiguration(classes = {DaoConfig.class, PersistenceContext.class})
public class QuestionDaoHibernateImplIntegrationTest {

}
