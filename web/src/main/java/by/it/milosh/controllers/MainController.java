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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by USER on 17.02.2017.
 */
@Controller
public class MainController {

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages/main");
        return modelAndView;
    }

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ModelAndView enter() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages/main");
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "pages/admin/adminMain";
    }

    @RequestMapping(value = "/loginCustomForm", method = RequestMethod.GET)
    public ModelAndView loginCustomForm(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Неправильный пароль!");
        }
        modelAndView.setViewName("pages/loginCustomForm");
        return modelAndView;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("errorMsg", user.getName() + " у вас нет доступа к этой странице!");
        } else {
            model.addObject("errorMsg", "У вас нет доступа к этой странице!");
        }
        model.setViewName("/accessDenied");
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "pages/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user,
                               BindingResult bindingResult, Model model,
                               @RequestParam String whoIs)  {
        if (bindingResult.hasErrors()) {
            return "registrationForm";
        }
        System.out.println(whoIs);
        Role role = new Role();
        if (whoIs.equals("student")) {
            role = roleService.findRoleByName("ROLE_STUDENT");
        } else if (whoIs.equals("teacher")) {
            role = roleService.findRoleByName("ROLE_TEACHER");
        }
        user.setRole(role);
        userService.addUser(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/";
    }

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public ModelAndView personal() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByName(getPrincipal());
        Role role = user.getRole();
        String roleName = role.getRoleName();
        if (roleName.equals("ROLE_STUDENT")) {
            modelAndView.setViewName("pages/student/personal");
        } else if (roleName.equals("ROLE_TEACHER")) {
            modelAndView.setViewName("pages/teacher/personal");
        }

        Long user_id = user.getUser_id();
        List<UserCourse> userCourses = userCourseService.getAllUserCourseByUserId(user_id);
        modelAndView.addObject("userCourses", userCourses);

        List<Course> courses = courseService.getAllCourse();
        List<String> courseNames = new ArrayList<String>();
        for (int i=0; i<courses.size(); i++) {
            String cN = courses.get(i).getCourseName();
            courseNames.add(cN);
        }
        modelAndView.addObject("courseNames", courseNames);

        Course course = new Course();
        modelAndView.addObject("course", course);

        return modelAndView;
    }

}
