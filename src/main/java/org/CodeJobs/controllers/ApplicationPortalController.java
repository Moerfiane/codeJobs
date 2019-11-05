package org.CodeJobs.controllers;

import org.CodeJobs.models.data.JobDao;
import org.CodeJobs.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.CodeJobs.models.Apply;
import org.CodeJobs.models.Job;
import org.CodeJobs.models.data.ApplyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("apply")
public class ApplicationPortalController
{
//copy jobController?
    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("title", "Application Portal");
        model.addAttribute("jobs", (jobDao.findAll()));
        //model.addAttribute("apps", appDao.findAll());

        return "apply/index";
    }
//change model to show jobs and change here
    @RequestMapping(value="apply", method = RequestMethod.GET)
    public String applyJob(Model model) {
        model.addAttribute("jobs", (jobDao.findAll()));

        /*model.addAttribute("name", "Enter your name");
        model.addAttribute("jobTitle", "Enter name of job");
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
        model.addAttribute(new App());*/




        return "app/apply";
    }

    /*@RequestMapping(value = "apply", method = RequestMethod.POST)
    public String processApply(Model model, @ModelAttribute @Valid Apply newApply, Job newJob, HttpSession session,
                               Errors errors, HttpServletRequest request, HttpServletResponse response) {

        if(errors.hasErrors()){
            //model.addAttribute("jobs", (jobDao.findAll()));
            return "app/apply";
        }
        model.addAttribute("jobs", (jobDao.findAll()));
        applyDao.save(newApply);

        return "redirect:/apply";
    }


    @RequestMapping(value="applicants", method=RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable("apply") int appId) {

        model.addAttribute("title", "Apply");
        model.addAttribute("apply", applyDao.findOne(appId));

        return "apply/applicants";
    }*/

    @RequestMapping(value="applicants", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable("apply") int applyId, @ModelAttribute  @Valid Apply newApply, Job newJob,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Apply");
            return "applicants";
        }
        //int hunter;
        for (int i = 0; i <= 100; i++) {
            applyId = 0;
            if (applyId % 1 == 0) {
                applyId += i;
            }

        }

        return "redirect:/applicants";
    }


}