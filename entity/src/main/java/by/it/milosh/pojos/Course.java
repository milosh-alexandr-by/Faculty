package by.it.milosh.pojos;

import javax.persistence.*;
import java.util.HashSet;
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
    private Set<UserCourse> studentCourse = new HashSet<UserCourse>();

    public Course() {
    }

    public Course(String courseName, Set<UserCourse> studentCourse) {
        this.courseName = courseName;
        this.studentCourse = studentCourse;
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

    public Set<UserCourse> getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(Set<UserCourse> studentCourse) {
        this.studentCourse = studentCourse;
    }
}
