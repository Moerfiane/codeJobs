package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.stlyouthjobs.models.Education;
import org.stlyouthjobs.models.data.EducationDao;

import javax.validation.Valid;

@Controller
@RequestMapping("education")
public class EducationController {

    @Autowired
    private EducationDao educationDao;

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("schoolName", "Add School Name");
        model.addAttribute("degree", "Add Degree");
        model.addAttribute("fieldOfStudy", "Add Field of Study");
        model.addAttribute("startDate", "Add Start Date");
        model.addAttribute("CompletionDate", "Add Completion Date");
        model.addAttribute(new Education());

        return "education/add";
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String processAdd(@ModelAttribute @Valid Education newEducation, Errors errors, @RequestParam int educationId, Model model){
        if (errors.hasErrors()){
            model.addAttribute("schoolName", "Add School Name");
            model.addAttribute("degree", "Add Degree");
            model.addAttribute("fieldOfStudy", "Add Field of Study");
            model.addAttribute("startDate", "Add Start Date");
            model.addAttribute("completionDate", "Add Commpletion Date");

            return "education/add";
        }
        educationDao.save(newEducation);
        return "redirect:/communityInvolvement";

    }


}