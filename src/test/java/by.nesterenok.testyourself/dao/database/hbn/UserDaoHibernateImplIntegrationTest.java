package by.nesterenok.testyourself.dao.database.hbn;

import static org.hamcrest.junit.MatcherAssert.assertThat;

import java.util.List;
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
    public static final String NEW_EMAIL = "new email";
    public static final String NEW_NAME = "new name";
    public static final String NEW_SURNAME = "new surname";
    private static User toCreate;

    @Autowired
    private UserDao userDao;

    @BeforeAll
    public static void init() {
        toCreate = new User();
        toCreate.setName(NAME);
        toCreate.setSurname(SURNAME);
        toCreate.setLogin(LOGIN);
        toCreate.setPassword(PASSWORD);
        toCreate.setRole(ROLE_USER);
        toCreate.setEmail(EMAIL);
    }

    @Test
    public void createAndReadTest() {
        userDao.create(toCreate);
        User actual = userDao.findByLogin(toCreate.getLogin());
        assertThat("User entity should not be null", actual, Matchers.notNullValue());
        assertThat("User field `name` should match expected value", actual.getName(),
            Matchers.equalTo(toCreate.getName()));
        assertThat("User field `surname` should match expected value", actual.getSurname(),
            Matchers.equalTo(toCreate.getSurname()));
        assertThat("User field `login` should match expected value", actual.getLogin(),
            Matchers.equalTo(toCreate.getLogin()));
        assertThat("User field `password` should match expected value", actual.getPassword(),
            Matchers.equalTo(toCreate.getPassword()));
        assertThat("User field `role` should match expected value", actual.getRole(),
            Matchers.equalTo(toCreate.getRole()));
        assertThat("User field `eMail` should match expected value", actual.getEmail(),
            Matchers.equalTo(toCreate.getEmail()));
    }

    @Test
    public void deleteTest() {
        userDao.create(toCreate);
        User user = userDao.findByLogin(toCreate.getLogin());
        userDao.delete(user);
        User actual = userDao.findByLogin(toCreate.getLogin());
        assertThat("Method should return null", actual, Matchers.nullValue());
    }

    @Test
    public void updateTest() {
        userDao.create(toCreate);
        User updated = userDao.findByLogin(toCreate.getLogin());
        updated.setEmail(NEW_EMAIL);
        updated.setName(NEW_NAME);
        updated.setSurname(NEW_SURNAME);
        userDao.update(updated);
        User actual = userDao.findByLogin(toCreate.getLogin());
        assertThat("Field `email` should match", actual.getEmail(), Matchers.equalTo(updated.getEmail()));
        assertThat("Field `name` should match", actual.getName(), Matchers.equalTo(updated.getName()));
        assertThat("Field `surname` should match", actual.getSurname(), Matchers.equalTo(updated.getSurname()));
        assertThat("Field `role` should match", actual.getRole(), Matchers.equalTo(updated.getRole()));
    }

    @Test
    public void readAllTest() {
        List<User> actual = userDao.readAll();
        assertThat("Actual list should not be null", actual, Matchers.notNullValue());
    }

    @Test
    public void findByLoginTest() {
        userDao.create(toCreate);
        //TODO implement
    }

    @Test
    public void counterTest() {
        //TODO implement
    }
}
