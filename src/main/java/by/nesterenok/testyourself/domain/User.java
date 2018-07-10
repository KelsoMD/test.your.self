package by.nesterenok.testyourself.domain;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@javax.persistence.Entity
@Table(name = User.USERS)
public class User extends Entity {

    public static final String ID = "id";
    private static final long serialVersionUID = -1402640880243152460L;
    public static final String USERS = "users";
    public static final String LOGIN = "login";
    public static final String PASS = "pass";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String E_MAIL = "e_mail";
    public static final String ROLE = "role";
    public static final String THEME = "theme";
    public static final String MEMBER = "member";
    public static final String GROUP_ID = "group_id";
    public static final String GROUP_MEMBERS = "group_members";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = LOGIN, unique = true)
    private String login;

    @Column(name = PASS)
    private String password;
    @Column(name = NAME)
    private String name;
    @Column(name = SURNAME)
    private String surname;
    @Column(name = E_MAIL)
    private String email;
    @Transient
    private File avatar;
    @Column(name = ROLE)
    private String role;
    @Column(name = THEME)
    private String theme;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Group.class)
    @JoinTable(name = GROUP_MEMBERS, joinColumns = @JoinColumn(name = MEMBER, referencedColumnName = ID),
            inverseJoinColumns = @JoinColumn(name = GROUP_ID, referencedColumnName = ID))
    private Set<Group> group;

    public User(int id) {
        super(id);
    }
}
