package by.it.milosh.pojos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by USER on 17.02.2017.
 */
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long course_id;

    @Column(name = "courseName")
    private String courseName;

    @OneToMany(mappedBy = "course")
    private List<UserCourse> userCourse = new ArrayList<UserCourse>();

    public Course() {
    }

    public Course(String courseName, List<UserCourse> userCourse) {
        this.courseName = courseName;
        this.userCourse = userCourse;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<UserCourse> getUserCourse() {
        return userCourse;
    }

    public void setUserCourse(List<UserCourse> userCourse) {
        this.userCourse = userCourse;
    }
}
