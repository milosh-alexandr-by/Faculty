package by.it.milosh.controllers;

import by.it.milosh.pojos.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by USER on 17.02.2017.
 */
@Controller
public class MainController {

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

}
