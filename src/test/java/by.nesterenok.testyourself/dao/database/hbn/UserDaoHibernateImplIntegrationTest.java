package by.nesterenok.testyourself.dao.database.hbn;

import static org.hamcrest.junit.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.spring.configuration.DaoConfig;
import by.nesterenok.testyourself.spring.configuration.PersistenceContext;

@ExtendWith(SpringExtension.class)
@Transactional
@ContextConfiguration(classes = {PersistenceContext.class, DaoConfig.class})
public class UserDaoHibernateImplIntegrationTest {

    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String EMAIL = "Email";

    @Autowired
    private UserDao userDao;
    private static User toCreate;

    @BeforeAll
    public static void init(){
        toCreate = new User();
        toCreate.setName(NAME);
        toCreate.setSurname(SURNAME);
        toCreate.setLogin(LOGIN);
        toCreate.setPassword(PASSWORD);
        toCreate.setRole(ROLE_USER);
        toCreate.setEmail(EMAIL);
    }

    @Test
    public void createAndReadTest(){
        userDao.create(toCreate);
        User actual = userDao.findByLogin(NAME);
        assertThat("User entity should not be null", actual, Matchers.notNullValue());
        assertThat("User field `name` should match expected value", actual.getName(), Matchers.equalTo(toCreate.getName()));
        assertThat("User field `surname` should match expected value", actual.getSurname(), Matchers.equalTo(toCreate.getSurname()));
        assertThat("User field `login` should match expected value", actual.getLogin(), Matchers.equalTo(toCreate.getLogin()));
        assertThat("User field `password` should match expected value", actual.getPassword(), Matchers.equalTo(toCreate.getPassword()));
        assertThat("User field `role` should match expected value", actual.getRole(), Matchers.equalTo(toCreate.getRole()));
        assertThat("User field `eMail` should match expected value", actual.getEmail(), Matchers.equalTo(toCreate.getEmail()));
    }

}
