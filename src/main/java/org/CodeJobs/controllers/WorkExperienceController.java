package org.CodeJobs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.CodeJobs.models.WorkExperience;
import org.CodeJobs.models.data.WorkExperienceDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("workexperience")
public class WorkExperienceController {

    @Autowired
    private WorkExperienceDao workExperienceDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Work Experience");
        model.addAttribute("workExperience", workExperienceDao.findAll());

        return "workexperience/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Job Experience");
        model.addAttribute(new WorkExperience());
        return "workexperience/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid WorkExperience newWorkExperience, HttpSession session,  Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("Statement", "Add Job Experience");
            return "workexperience/add";
        }
        Integer name =(Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        newWorkExperience.setSession(name);

        workExperienceDao.save(newWorkExperience);
        return "redirect:/education/add";

    }

    @RequestMapping(value = "edit/{workId}", method = RequestMethod.GET)
    public String displayEditWorkExpForm(Model model, @PathVariable int workId) {

        model.addAttribute("title", "Edit Work Experience");
        model.addAttribute("workExperience", workExperienceDao.findOne(workId));

        return "workexperience/edit";

    }

    @RequestMapping(value = "edit/{workId}", method = RequestMethod.POST)
    public String processEditWorkExpForm(Model model, @PathVariable int workId, @ModelAttribute @Valid
                                         WorkExperience newWorkExperience, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Work Experience");
            return "workexperience/edit";
        }

        WorkExperience editedWorkExperience = workExperienceDao.findOne(workId);
        editedWorkExperience.setJobTitle(newWorkExperience.getJobTitle());
        editedWorkExperience.setCompanyName(newWorkExperience.getCompanyName());
        editedWorkExperience.setLocation(newWorkExperience.getLocation());
        editedWorkExperience.setStartDate(newWorkExperience.getStartDate());
        editedWorkExperience.setEndDate(newWorkExperience.getEndDate());
        editedWorkExperience.setCurrent(newWorkExperience.getCurrent());
        editedWorkExperience.setDetail1(newWorkExperience.getDetail1());
        editedWorkExperience.setDetail2(newWorkExperience.getDetail2());
        editedWorkExperience.setDetail3(newWorkExperience.getDetail3());
        workExperienceDao.save(editedWorkExperience);

        return "redirect:/workexperience/";


    }
}
