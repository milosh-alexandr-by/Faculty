package by.it.milosh.pojos;

import javax.persistence.*;

/**
 * Created by USER on 17.02.2017.
 */
@Entity
@Table(name = "userCourse")
public class UserCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_course_id")
    private Long user_course_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "rating")
    private Integer rating;

}
