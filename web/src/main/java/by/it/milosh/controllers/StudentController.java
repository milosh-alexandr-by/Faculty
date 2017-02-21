package by.it.milosh.controllers;

import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import by.it.milosh.pojos.UserCourse;
import by.it.milosh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

    @RequestMapping(value = "/personal", method = RequestMethod.POST)
    public ModelAndView addCourseToUser(@ModelAttribute("course") Course course, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("pages/student/personal");
            return modelAndView;
        }
        Long user_id = userService.findUserByName(getPrincipal()).getUser_id();
        Long course_id = courseService.findCourseByName(course.getCourseName()).getCourse_id();
        userCourseService.addCourseToUser(user_id, course_id);
        modelAndView.setViewName("pages/student/personal");

        List<UserCourse> userCourses = userCourseService.getAllUserCourseByUserId(user_id);
        modelAndView.addObject("userCourses", userCourses);

        List<Course> courses = courseService.getAllCourse();
        List<String> courseNames = new ArrayList<String>();
        for (int i=0; i<courses.size(); i++) {
            String cN = courses.get(i).getCourseName();
            courseNames.add(cN);
        }
        modelAndView.addObject("courseNames", courseNames);

        Course course2 = new Course();
        modelAndView.addObject("course", course2);

        return modelAndView;
    }

}
