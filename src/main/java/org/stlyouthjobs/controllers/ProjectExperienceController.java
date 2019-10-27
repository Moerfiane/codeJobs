package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.ProjectExperience;
import org.stlyouthjobs.models.data.ProjectExperienceDao;
import org.stlyouthjobs.models.data.UserDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("projectexperience")
public class ProjectExperienceController {

    @Autowired
    private ProjectExperienceDao projectExperienceDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "Display Projects");
        model.addAttribute("projects", projectExperienceDao.findAll());
        return "projectexperience/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Project Experience");
        model.addAttribute(new ProjectExperience());
        return "projectexperience/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid ProjectExperience newProjectExperience,
                             HttpSession session, Errors errors){
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

    @RequestMapping(value = "edit/{projectExperienceId}", method = RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int projectExperienceId) {

        model.addAttribute("title", "Edit Applicant");
        model.addAttribute("projectexperience", projectExperienceDao.findOne(projectExperienceId));

        return "projectexperience/edit";

    }

    @RequestMapping(value = "edit/{projectExperienceId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int projectExperienceId, @ModelAttribute @Valid
            ProjectExperience projectExperience, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Applicant");
            return "newapplicant/edit";
        }

        ProjectExperience editedProject = projectExperienceDao.findOne(projectExperienceId);
        editedProject.setName(projectExperience.getName());
        editedProject.setSummary(projectExperience.getSummary());
        editedProject.setDetail1(projectExperience.getDetail1());
        editedProject.setDetail2(projectExperience.getDetail2());
        editedProject.setDetail3(projectExperience.getDetail3());
        projectExperienceDao.save(editedProject);

        return "redirect:/projectexperience/";

    }

}
