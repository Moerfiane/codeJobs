package org.CodeJobs.controllers;

import org.CodeJobs.models.User;
import org.CodeJobs.models.forms.LoginForm;
import org.CodeJobs.models.forms.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by LaunchCode
 */

@Controller
@RequestMapping("register")
public class AuthenticationController extends AbstractController {


    @RequestMapping(value = "applicant", method = RequestMethod.GET)
    public String registerApplicantForm(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("title", "Register");
        return "register/applicant";
    }

    @RequestMapping(value = "applicant", method = RequestMethod.POST)
    public String registerApplicantForm(HttpSession  session, @ModelAttribute @Valid RegisterForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "register/applicant";
        }

        User existingUser = userDao.findByUsername(form.getUsername());
        String access = form.getAccess();


        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            return "register/applicant";
        }

        User newUser = new User(form.getUsername(), form.getPassword(), form.getAccess());
        userDao.save(newUser);
        session.setAttribute("username",newUser.getUsername());
        setUserInSession(request.getSession(), newUser);

        if (form.getAccess().equals("2")) {
            return "redirect:/newapplicant/add";
        }

        return "redirect:/statement/add";
    }

    @RequestMapping(value = "employer", method = RequestMethod.GET)
    public String registerEmployerForm(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("title", "Register");
        return "register/employer";
    }

    @RequestMapping(value = "employer", method = RequestMethod.POST)
    public String registerEmployerForm(HttpSession  session, @ModelAttribute @Valid RegisterForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "/register/employer";
        }

        User existingUser = userDao.findByUsername(form.getUsername());
//        String access = form.getAccess();


        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            return "/register/employer";
        }

        User newUser = new User(form.getUsername(), form.getPassword(), form.getAccess());
        userDao.save(newUser);
        session.setAttribute("username",newUser.getUsername());
        setUserInSession(request.getSession(), newUser);

        if (form.getAccess().equals("3")) {
            return "redirect:/newemployer/add";
        }
        return "redirect:/register/employer";
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String registerAdminForm(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("title", "Register");
        return "register/admin";
    }

    @RequestMapping(value = "admin", method = RequestMethod.POST)
    public String registerAdminForm(HttpSession  session, @ModelAttribute @Valid RegisterForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "/register/admin";
        }

        User existingUser = userDao.findByUsername(form.getUsername());



        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            return "register";
        }

        User newUser = new User(form.getUsername(), form.getPassword(), form.getAccess());
        userDao.save(newUser);
        session.setAttribute("username",newUser.getUsername());
        setUserInSession(request.getSession(), newUser);


        if (form.getAccess().equals("1")){
            return "redirect:/job";
        }
        return "redirect:/register";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new LoginForm());
        model.addAttribute("title", "Log In");
        return "/register/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession  session, @ModelAttribute @Valid LoginForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "/register/login";
        }

        User theUser = userDao.findByUsername(form.getUsername());
        String password = form.getPassword();

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            return "/register/login";
        }


        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            return "register";
        }
        session.setAttribute("userId",theUser.getUid());
        setUserInSession(request.getSession(), theUser);

        if (theUser.getAccess().equals("1")) {
            return "redirect:/admin";
        }

        if (theUser.getAccess().equals("2")) {
            return "redirect:/resume";
        }
        if (theUser.getAccess().equals("3")) {
            return "redirect:/job";
        } else {
            return "redirect:/register/login";
        }
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }

}
