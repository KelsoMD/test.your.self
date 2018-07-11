package by.nesterenok.testyourself.domain;

import java.util.Date;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class TaskResult extends Entity {

    private static final long serialVersionUID = -5337827687156290711L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "member")
    private User member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Task.class)
    @JoinColumn(name = "task")
    private Task task;

    @Column(name = "date")
    private Date passDate;

    @Column(name = "mark")
    private int mark;

    @Column(name = "passed")
    private boolean passed;

    @ManyToMany
    @JoinTable(name = "anser_map", joinColumns = {
        @JoinColumn(name = "fk_taskresult", referencedColumnName = "taskresult_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_question", referencedColumnName = "id")})
    @MapKeyColumn(name = "question_id")
    @Column(name = "answer")
    //TODO to test
    private Map<Question, String> answerMap;

    public TaskResult(int id) {
        super(id);
    }
}
