package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.stlyouthjobs.models.Education;
import org.stlyouthjobs.models.data.EducationDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("education")
public class EducationController {

    @Autowired
    private EducationDao educationDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Education");
        model.addAttribute("education", educationDao.findAll());

        return "education/index";
    }

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("schoolName", "Add School Name");
        model.addAttribute("degree", "Add Degree");
        model.addAttribute("startDate", "Add Start Date");
        model.addAttribute("CompletionDate", "Add Completion Date");
        model.addAttribute(new Education());

        return "education/add";
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid Education newEducation, HttpSession session, Errors errors){
        if (errors.hasErrors()){
            model.addAttribute("schoolName", "Add School Name");
            model.addAttribute("degree", "Add Degree");
            model.addAttribute("startDate", "Add Start Date");
            model.addAttribute("completionDate", "Add Completion Date");

            return "education/add";
        }

        Integer name =(Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        newEducation.setSession(name);

        educationDao.save(newEducation);
        return "redirect:/applicantportal/add";

    }

    @RequestMapping(value = "edit/{educationId}", method = RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int educationId) {

        model.addAttribute("title", "Edit Education");
        model.addAttribute("education", educationDao.findOne(educationId));

        return "education/edit";

    }


    @RequestMapping(value = "edit/{educationId}", method = RequestMethod.POST)
    public String processEditJobForm(Model model, @PathVariable int educationId, @ModelAttribute @Valid Education newEducation,
                                     Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Education");
            return "education/edit";
        }

        Education editedEducation = educationDao.findOne(educationId);
        editedEducation.setSchoolName(newEducation.getSchoolName());
        editedEducation.setDegree(newEducation.getDegree());
        editedEducation.setStartDate(newEducation.getStartDate());
        editedEducation.setCompletionDate(newEducation.getCompletionDate());
        editedEducation.setCurrent(newEducation.getCurrent());
        educationDao.save(editedEducation);

        return "redirect:/education/";



    }


}