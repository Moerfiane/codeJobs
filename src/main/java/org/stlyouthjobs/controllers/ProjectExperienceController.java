package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.ProjectExperience;
import org.stlyouthjobs.models.data.ProjectExperienceDao;

import javax.validation.Valid;

@Controller
@RequestMapping("projectexperience")
public class ProjectExperienceController {

    @Autowired
    private ProjectExperienceDao projectExperienceDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Project Experience");
        model.addAttribute(new ProjectExperience());
        return "projectexperience/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid ProjectExperience newProjectExperience, Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("Statement", "Add Project Experience");
            return "projectexperience/add";
        }

        projectExperienceDao.save(newProjectExperience);
        return "redirect:/skills/add";
    }
}
