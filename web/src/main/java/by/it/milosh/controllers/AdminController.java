package by.it.milosh.controllers;

import by.it.milosh.pojos.User;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by USER on 18.02.2017.
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/allCourses", method = RequestMethod.GET)
    public ModelAndView allCourses() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages/admin/allCourses");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/allStudents", method = RequestMethod.GET)
    public ModelAndView allStudents() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.getAllUserByRole("ROLE_STUDENT");
        modelAndView.addObject("users", users);
        modelAndView.setViewName("pages/admin/allStudents");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/allTeachers", method = RequestMethod.GET)
    public ModelAndView allTeachers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.getAllUserByRole("ROLE_TEACHER");
        modelAndView.addObject("users", users);
        modelAndView.setViewName("pages/admin/allTeachers");
        return modelAndView;
    }

}
