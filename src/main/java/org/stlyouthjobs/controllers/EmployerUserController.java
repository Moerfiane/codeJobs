package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.EmployerUser;
import org.stlyouthjobs.models.data.EmployerUserDao;


import javax.validation.Valid;

@Controller
@RequestMapping("employerUser")
public class EmployerUserController {

    @Autowired
    private EmployerUserDao employerUserDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("email", "E-mail");
        model.addAttribute("confirmEmail", "Confirm E-mail");
        model.addAttribute("password", "Password");
        model.addAttribute("confirmPassword", "Confirm Password");
        model.addAttribute(new EmployerUser());

        return "newemployer/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String employerUser (Model model, @ModelAttribute @Valid EmployerUser employerUser, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("email", "E-mail");
            model.addAttribute("confirmEmail", "Confirm E-mail");
            model.addAttribute("password", "Password");
            model.addAttribute("confirmPassword", "Confirm Password");
            return "newemployer/add";
        }
        employerUserDao.save(employerUser);
        return "redirect:/addNewJob";
    }
}
