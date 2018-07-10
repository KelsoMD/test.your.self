package by.nesterenok.testyourself.domain;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Entity implements Serializable {

    private static final long serialVersionUID = -1475272946217952514L;

    private int id;

    public Entity(int id) {
        super();
        this.id = id;
    }
}
