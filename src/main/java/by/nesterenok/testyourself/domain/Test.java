package by.nesterenok.testyourself.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@javax.persistence.Entity
@Table(name = Test.TESTS)
public class Test extends Entity {

    public static final String TEST = "test";
    private static final long serialVersionUID = 1284463822482349681L;
    public static final String TESTS = "tests";
    public static final String THEME = "theme";
    public static final String LEVEL = "level";
    public static final String AUTHOR = "author";
    public static final String ID = "id";
    public static final String TEST_QUESTIONS = "test_questions";
    public static final String QUESTION = "question";
    public static final String APROOVED = "aprooved";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = THEME)
    private String theme;

    @Column(name = LEVEL)
    private int lvl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = AUTHOR)
    private User author;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Question.class)
    @JoinTable(name = TEST_QUESTIONS, joinColumns = @JoinColumn(name = TEST, referencedColumnName = ID),
            inverseJoinColumns = @JoinColumn(name = QUESTION, referencedColumnName = ID))
    private Set<Question> questions;

    @Column(name = APROOVED)
    private boolean aprooved;

    public Test(int id) {
        super(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        if (!super.equals(o)) return false;
        Test test = (Test) o;
        return id == test.id &&
                lvl == test.lvl &&
                aprooved == test.aprooved &&
                Objects.equals(theme, test.theme) &&
                Objects.equals(author, test.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, theme, lvl, author, aprooved);
    }
}
