package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.stlyouthjobs.models.Job;
import org.stlyouthjobs.models.data.JobDao;

import javax.validation.Valid;

@Controller
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobDao jobDao;

    @RequestMapping(value = "add", method= RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("jobTitle", "Add Job Title");
        model.addAttribute("address", "Add Address");
        model.addAttribute("jobCategory", "Select Job Category");
        model.addAttribute("jobSummary", "Add Job Summary");
        model.addAttribute("location", "Add Location");
        model.addAttribute("schedule", "Add Schedule");
        model.addAttribute("positionType", "Add Position Type");
        model.addAttribute("numOfPositions", "Add Number of Positions");
        model.addAttribute("dressCode", "Add Dress Code");
        model.addAttribute("payRate", "Add Pay Rate");
        model.addAttribute("closingDate", "Add Closing Date");
        model.addAttribute(new Job());

        return "job/add";
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String processAdd(Model model, @ModelAttribute @Valid Job newJob, Errors errors){
        if (errors.hasErrors()){
            model.addAttribute("jobTitle", "Add Job Title");
            model.addAttribute("address", "Add Address");
            model.addAttribute("jobCategory", "Select Job Category");
            model.addAttribute("jobSummary", "Add Job Summary");
            model.addAttribute("location", "Add Location");
            model.addAttribute("schedule", "Add Schedule");
            model.addAttribute("positionType", "Add Position Type");
            model.addAttribute("numOfPositions", "Add Number of Positions");
            model.addAttribute("dressCode", "Add Dress Code");
            model.addAttribute("payRate", "Add Pay Rate");
            model.addAttribute("closingDate", "Add Closing Date");

            return "job/add";
        }
        jobDao.save(newJob);
        //need to know where this redirects to
        return "redirect:/cheese";

    }

}