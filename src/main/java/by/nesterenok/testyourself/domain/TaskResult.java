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
    private int id;
    private User member;
    private Task task;
    private Date passDate;
    private int mark;
    private boolean passed;
    private Map<Question, String> answerMap;

    public TaskResult(int id) {
        super(id);
    }
}
