package by.it.milosh.controllers;

import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.User;
import by.it.milosh.pojos.UserCourse;
import by.it.milosh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by USER on 19.02.2017.
 */
@Controller
public class StudentController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserCourseService userCourseService;

    @Autowired
    private CourseService courseService;

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        }
        else {
            userName = principal.toString();
        }
        return userName;
    }

    @RequestMapping(value = "/student/addCourseToUser", method = RequestMethod.GET)
    public ModelAndView addCourseToUser(@RequestParam String title) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByName(getPrincipal());
        Long user_id = user.getUser_id();
        Course course = courseService.findCourseByName(title);
        Long course_id = course.getCourse_id();
        userCourseService.addCourseToUser(user_id, course_id);
        modelAndView.setViewName("pages/student/personal");
        List<UserCourse> userCourses = userCourseService.getAllUserCourseByUserId(user_id);
        modelAndView.addObject("userCourses", userCourses);
        return modelAndView;
    }

}
