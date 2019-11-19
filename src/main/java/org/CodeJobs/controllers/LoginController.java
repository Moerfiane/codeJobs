package org.CodeJobs.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.CodeJobs.models.User;
import org.CodeJobs.models.forms.LoginForm;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public class LoginController extends AbstractController{

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new LoginForm());
        model.addAttribute("title", "Log In");
        return "register/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid LoginForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "register/index";
        }

        User theUser = userDao.findByUsername(form.getUsername());
        String password = form.getPassword();

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            return "register/index";
        }



        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            return "register/index";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:job/index";
    }
}
