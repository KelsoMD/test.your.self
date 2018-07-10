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
@Table(name = Invite.INVITE)
public class Invite extends Entity {

    private static final long serialVersionUID = -9009350671599623118L;
    public static final String INVITE = "invite";
    public static final String MEMBER = "member";
    public static final String GROUP_ID = "group_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = MEMBER)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Group.class)
    @JoinColumn(name = GROUP_ID)
    private Group group;

    public Invite(int id) {
        super(id);
    }
}
