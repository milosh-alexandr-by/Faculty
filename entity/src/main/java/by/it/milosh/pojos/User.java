package by.it.milosh.pojos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by USER on 17.02.2017.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<Role>();

    @OneToMany(mappedBy = "user")
    private Set<UserCourse> studentCourse = new HashSet<UserCourse>();

    public User() {
    }

    public User(String username, String password, String firstName, String lastName, Set<Role> roles, Set<UserCourse> studentCourse) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.studentCourse = studentCourse;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<UserCourse> getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(Set<UserCourse> studentCourse) {
        this.studentCourse = studentCourse;
    }
}
