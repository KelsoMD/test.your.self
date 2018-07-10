package by.nesterenok.testyourself.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@javax.persistence.Entity
@Table(name = Question.QUESTIONS)
public class Question extends Entity {

    private static final long serialVersionUID = -2620731943808722423L;
    public static final String QUESTIONS = "questions";
    public static final String THEME = "theme";
    public static final String LEVEL = "level";
    public static final String TEXT = "text";
    public static final String IMAGE = "image";
    public static final String ANSWER_CORRECT = "answer_correct";
    public static final String ANSWER_1 = "answer_1";
    public static final String ANSWER_2 = "answer_2";
    public static final String ANSWER_3 = "answer_3";
    public static final String AUTHOR = "author";
    public static final String APROOVED = "aprooved";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @Column(name = THEME)
    private String theme;

    @Column(name = LEVEL)
    private int lvl;

    @Column(name = TEXT)
    private String text;

    @Column(name = IMAGE)
    private String image;

    @Column(name = ANSWER_CORRECT)
    private String correctAnswer;
    @Column(name = ANSWER_1)
    private String answer1;
    @Column(name = ANSWER_2)
    private String answer2;
    @Column(name = ANSWER_3)
    private String answer3;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = AUTHOR)
    private User author;
    @Column(name = APROOVED)
    private boolean aprooved;

    @Transient
    private List<String> shuffledAnswers;

    public Question(int id) {
        super(id);
    }
}
