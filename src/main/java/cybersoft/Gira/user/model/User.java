package cybersoft.Gira.user.model;

import cybersoft.Gira.common.model.BaseEntity;
import cybersoft.Gira.role.model.UserGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = UserEntity.User.TABLE_NAME)

// ===========================================================================================
@NamedQueries({
        @NamedQuery(name = "User.findByUsernameLikeIgnoreCase",
                query = "select u from User u where upper(u.accountName) like upper(:accountName)")
})
// ===========================================================================================
public class User extends BaseEntity {
    // system Information
    // count name cua minh' = username cua anh Tuan
    @Column(name = UserEntity.User.ACCOUNT_NAME, unique = true
            ,nullable = false
            , length = 100
            , updatable = false)
    private String accountName;

    @Column(name = UserEntity.User.PASSWORD, nullable = false)
    private String password;

    @Column(name = UserEntity.User.FULLNAME, unique = true,nullable = false,length = 100)
    private String fullName;

    //userName cua minh' = displayName cua anh Tuan
    @Column(name = UserEntity.User.USERNAME)
    private String userName;

    @Column(name = UserEntity.User.AVATAR)
    private String avatar;

    @Column(name = UserEntity.User.EMAIL, unique = true, length = 100,nullable = false)
    private String email;

    @Column(name = UserEntity.User.STATUS)
    @Enumerated(EnumType.STRING)
    private status accountStatus;

    // personal Information
    @Column(name = UserEntity.User.FACEBOOK_LINK)
    private String FacebookLink;


    // job = majority
    @Column(name = UserEntity.User.JOB)
    private String job;

    @Column(name = UserEntity.User.DEPARTMENT)
    private String department;

    // hobby = hobbies
    @Column(name = UserEntity.User.HOBBY)
    private String hobby;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "g_user_groups_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_group_id"))
    private Set<UserGroup> userGroups = new LinkedHashSet<>();

    public enum status {
        ACTIVE,
        TEMPORARY_BLOCK,
        PERMANENT_BLOCK
    }
}
