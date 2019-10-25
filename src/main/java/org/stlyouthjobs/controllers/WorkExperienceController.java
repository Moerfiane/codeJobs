package org.stlyouthjobs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.WorkExperience;
import org.stlyouthjobs.models.data.WorkExperienceDao;

import javax.validation.Valid;

@Controller
@RequestMapping("workexperience")
public class WorkExperienceController {


    @Autowired
    private WorkExperienceDao workExperienceDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Job Experience");
        model.addAttribute(new WorkExperience());
        return "workexperience/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid WorkExperience newWorkExperience, Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("Statement", "Add Job Experience");
            return "workexperience/add";
        }

        workExperienceDao.save(newWorkExperience);
        return "redirect:/education/add";
    }
}
