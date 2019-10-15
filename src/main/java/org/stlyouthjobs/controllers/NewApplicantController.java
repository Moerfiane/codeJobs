package org.stlyouthjobs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.NewApplicant;
import org.stlyouthjobs.models.data.NewApplicantDao;

import javax.validation.Valid;

@Controller
@RequestMapping("newapplicant")
public class NewApplicantController {

    @Autowired
    private NewApplicantDao newApplicantDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "New Applicant");
        model.addAttribute(new NewApplicant());
        return "newapplicant/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid NewApplicant newApplicant, Errors errors) {

        if (errors.hasErrors()) {
        model.addAttribute("title", "New Applicant");
        return "newapplicant/add";
        }
        newApplicantDao.save(newApplicant);
        return "redirect:/contactinfo/add";
    }
}
