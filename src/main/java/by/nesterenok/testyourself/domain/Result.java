package by.nesterenok.testyourself.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@javax.persistence.Entity
@Table(name = Result.RESULT)
public class Result extends Entity {

    public static final String USER = "user";
    private static final long serialVersionUID = 278114355927793814L;
    public static final String RESULT = "result";
    public static final String TEST = "test";
    public static final String MARK = "mark";
    public static final String PASSED = "passed";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Test.class)
    @JoinColumn(name = TEST)
    private Test test;

    @Column(name = MARK)
    private int mark;

    @Column(name = PASSED)
    private boolean passed;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = USER)
    private User user;

    public Result(int id) {
        super(id);
    }
}