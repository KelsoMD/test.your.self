package by.nesterenok.testyourself.domain;

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
@javax.persistence.Entity
@Table(name = Themes.THEMES)
public final class Themes extends Entity {

    private static final long serialVersionUID = -3408505656073783893L;
    public static final String THEMES = "themes";
    public static final String THEME = "theme";
    public static final String APROOVED = "aprooved";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = THEME)
    private String theme;

    @Column(name = APROOVED)
    private boolean aprooved;

    public Themes(String theme) {
        this.theme = theme;
    }
}
