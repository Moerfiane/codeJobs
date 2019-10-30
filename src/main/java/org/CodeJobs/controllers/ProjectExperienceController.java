package org.CodeJobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.CodeJobs.models.ProjectExperience;
import org.CodeJobs.models.data.ProjectExperienceDao;

import javax.servlet.http.HttpSession;
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
    public String processAdd(Model model , @ModelAttribute @Valid ProjectExperience newProjectExperience, HttpSession session, Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("Statement", "Add Project Experience");
            return "projectexperience/add";
        }
        Integer name =(Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        newProjectExperience.setSession(name);

        projectExperienceDao.save(newProjectExperience);
        return "redirect:/workexperience/add";
    }
}
