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
import org.CodeJobs.models.App;
import org.CodeJobs.models.Job;
import org.CodeJobs.models.data.AppDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("app")
public class ApplicationPortalController
{
//copy jobController?
    @Autowired
    private AppDao appDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("title", "Application Portal");
        model.addAttribute("jobs", (jobDao.findAll()));
        //model.addAttribute("apps", appDao.findAll());

        return "app/index";
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

    @RequestMapping(value = "apply", method = RequestMethod.POST)
    public String processApply(Model model, @ModelAttribute @Valid App newApp, Job newJob, HttpSession session,
                               Errors errors, HttpServletRequest request, HttpServletResponse response) {

        if(errors.hasErrors()){
            //model.addAttribute("jobs", (jobDao.findAll()));
            return "app/apply";
        }
        model.addAttribute("jobs", (jobDao.findAll()));
        appDao.save(newApp);

        return "redirect:/app";
    }


    @RequestMapping(value="apply/{jobId}", method=RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int appId) {

        model.addAttribute("title", "Apply");
        model.addAttribute("app", appDao.findOne(appId));

        return "app/apply";
    }

    @RequestMapping(value="apply/{jobId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int appId, @ModelAttribute  @Valid App newApp,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Apply");
            return "app/apply";
        }
//should be resume?
        App applyApp = appDao.findOne(appId);
        applyApp.setJobTitle(newApp.getJobTitle());
        applyApp.setAddress(newApp.getAddress());
        applyApp.setJobCategory(newApp.getJobCategory());
        applyApp.setLocation(newApp.getLocation());
        applyApp.setSchedule(newApp.getSchedule());
        applyApp.setJobSummary(newApp.getJobSummary());
        applyApp.setPositionType(newApp.getPositionType());
        applyApp.setNumOfPositions(newApp.getNumOfPositions());
        applyApp.setDressCode(newApp.getDressCode());
        applyApp.setPayRate(newApp.getPayRate());
        applyApp.setClosingDate(newApp.getClosingDate());
        appDao.save(applyApp);

        return "redirect:/app";
    }


}