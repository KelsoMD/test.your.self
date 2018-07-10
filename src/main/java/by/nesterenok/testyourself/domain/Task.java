package by.nesterenok.testyourself.domain;

import java.util.Date;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@javax.persistence.Entity
@Table(name = Task.GROUP_TASK)
public class Task extends Entity {

    private static final long serialVersionUID = 563246732327679119L;
    public static final String GROUP_TASK = "group_task";
    public static final String PARTY = "party";
    public static final String TEST = "test";
    public static final String FINISH_TO = "finish_to";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Group.class)
    @JoinColumn(name = PARTY)
    private Group group;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Test.class)
    @JoinColumn(name = TEST)
    private Test test;

    @Column(name = FINISH_TO)
    private Date finishTo;

    public Task(int id) {
        super(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        if (!super.equals(o)) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(group, task.group) &&
                Objects.equals(test, task.test) &&
                Objects.equals(finishTo, task.finishTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, group, test, finishTo);
    }
}
