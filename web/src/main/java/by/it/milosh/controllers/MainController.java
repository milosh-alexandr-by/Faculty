package by.it.milosh.controllers;

import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import by.it.milosh.service.RoleService;
import by.it.milosh.service.SecurityService;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashSet;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
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
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        userService.addUser(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/";

    }

}
