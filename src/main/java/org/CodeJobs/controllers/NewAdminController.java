package org.CodeJobs.controllers;

import org.CodeJobs.models.NewApplicant;
import org.CodeJobs.models.User;
import org.CodeJobs.models.data.UserDao;
import org.CodeJobs.models.forms.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "admin")
public class NewAdminController extends AbstractController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerAdminForm(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("title", "Register");
        return "register/admin";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registerAdminForm(HttpSession  session, @ModelAttribute @Valid RegisterForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "/register/admin";
        }

        User existingUser = userDao.findByUsername(form.getUsername());



        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            return "/register";
        }

        User newUser = new User(form.getUsername(), form.getPassword(), form.getAccess());
        userDao.save(newUser);
        session.setAttribute("username",newUser.getUsername());
        setUserInSession(request.getSession(), newUser);


        if (form.getAccess().equals("1")) {
            return "redirect:/admin";
        }
        return "redirect:/register";
    }

}
