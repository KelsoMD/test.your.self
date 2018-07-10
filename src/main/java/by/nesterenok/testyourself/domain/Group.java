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
@Table(name = Group.GROUPS)
public class Group extends Entity {

    private static final long serialVersionUID = -7113150935056952534L;
    public static final String GROUPS = "groups";
    public static final String MENTOR = "mentor";
    public static final String THEME = "theme";
    public static final String GROUP_MEMBERS = "group_members";
    public static final String GROUP_ID = "group_id";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String MEMBER = "member";
    public static final String GROUP = "group";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = MENTOR)
    private User mentor;

    @Column(name = THEME)
    private String theme;

    @OneToMany(mappedBy = GROUP)
    private Set<Task> tasks;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinTable(name = GROUP_MEMBERS, joinColumns = @JoinColumn(name = GROUP_ID, referencedColumnName = ID),
            inverseJoinColumns = @JoinColumn(name = MEMBER, referencedColumnName = ID))
    private Set<User> members;

    @Column(name = TITLE)
    private String title;

    public Group(int id) {
        super(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        if (!super.equals(o)) return false;
        Group group = (Group) o;
        return id == group.id &&
                Objects.equals(mentor, group.mentor) &&
                Objects.equals(theme, group.theme) &&
                Objects.equals(tasks, group.tasks) &&
                Objects.equals(title, group.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, mentor, theme, title);
    }
}
