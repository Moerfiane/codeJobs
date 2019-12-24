package org.CodeJobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.CodeJobs.models.Job;
import org.CodeJobs.models.data.JobDao;
import org.CodeJobs.models.data.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="")
    public String index(Model model, HttpSession session){
        Integer username =(Integer) session.getAttribute("user_id");
        System.out.println(username + "new");
        model.addAttribute("jobs", (jobDao.session(username)));

        return "job/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Job");
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

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processJobAdd(@ModelAttribute @Valid Job newJob, HttpSession session, Errors errors, Model model,
                                HttpServletRequest request, HttpServletResponse response) {


        if (errors.hasErrors()) {
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

        Integer name =(Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        newJob.setSession(name);

        jobDao.save(newJob);

        return "redirect:/job";
    }

    @RequestMapping(value="edit/{jobId}", method=RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int jobId) {

        model.addAttribute("title", "Edit Job");
        model.addAttribute("job", jobDao.findOne(jobId));

        return "job/edit";
    }

    @RequestMapping(value="edit/{jobId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int jobId, @ModelAttribute  @Valid Job newJob,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "job/edit";
        }

        Job editedJob = jobDao.findOne(jobId);
        editedJob.setJobTitle(newJob.getJobTitle());
        editedJob.setAddress(newJob.getAddress());
        editedJob.setJobCategory(newJob.getJobCategory());
        editedJob.setLocation(newJob.getLocation());
        editedJob.setSchedule(newJob.getSchedule());
        editedJob.setJobSummary(newJob.getJobSummary());
        editedJob.setPositionType(newJob.getPositionType());
        editedJob.setNumOfPositions(newJob.getNumOfPositions());
        editedJob.setDressCode(newJob.getDressCode());
        editedJob.setPayRate(newJob.getPayRate());
        editedJob.setClosingDate(newJob.getClosingDate());
        jobDao.save(editedJob);

        return "redirect:/job";
    }

}