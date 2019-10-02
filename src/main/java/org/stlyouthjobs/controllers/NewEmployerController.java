package org.stlyouthjobs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.NewEmployer;
import org.stlyouthjobs.models.data.NewEmployerDao;

import javax.validation.Valid;

@Controller
@RequestMapping("employer")
public class NewEmployerController {

    @Autowired
    private NewEmployerDao newEmployerDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String employerRegisterForm(Model model) {
        model.addAttribute("title", "Add New Employer");
        model.addAttribute(new NewEmployer());

        return "employer/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String employerRegisterForm (Model model, @ModelAttribute @Valid NewEmployer newEmployer, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Employer");
            return "employer/add";
        }
        newEmployerDao.save(newEmployer);
        return "redirect: /addnewjob";
    }

}
