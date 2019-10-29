package org.stlyouthjobs.controllers;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.App;
import org.stlyouthjobs.models.data.AppDao;
import org.stlyouthjobs.models.data.JobDao;

import javax.validation.Valid;

@Controller
@RequestMapping("app")
public class ApplicationPortalController
{

    @Autowired
    private AppDao appDao;

    @Autowired
    private JobDao jobDao;

    @RequestMapping(value = "")
    public String index(Model model, ExpiresFilter.XHttpServletResponse){
        Integer user = (Integer) session.getAttribute("user_id");
        System.out.println(user + "new");
        model.addAttribute("title", "Application Portal");
        model.addAttribute("apps", appDao.findAll(user));
        model.addAttribute("jobTitle", jobDao.findOne());
        model.addAttribute("address", jobDao.findOne());
        model.addAttribute("jobCategory", jobDao.findOne());
        model.addAttribute("jobSummary", jobDao.findOne());
        model.addAttribute("location", jobDao.findOne());
        model.addAttribute("schedule", jobDao.findOne());
        model.addAttribute("positionType", jobDao.findOne());
        model.addAttribute("numOfPositions", jobDao.findOne());
        model.addAttribute("dressCode", jobDao.findOne());
        model.addAttribute("payRate", jobDao.findOne());
        model.addAttribute("closingDate", jobDao.findOne());

        return "app/index";
    }

    @RequestMapping(value="apply", method = RequestMethod.GET)
    public String applyJob(Model model) {

        model.addAttribute("name", "Enter your name");
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
        model.addAttribute(new App());

        return "app/apply";
    }

    @RequestMapping(value = "apply", method = RequestMethod.POST)
    public String processApply(Model model, @ModelAttribute @Valid App newApp, Errors errors) {

        if(errors.hasErrors()){
            model.addAttribute("name", "Enter your name");
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
            return "app/apply";
        }
        appDao.save(newApp);

        return "redirect:/app";
    }


    @RequestMapping(value="apply/{jobId}", method=RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int appId) {

        model.addAttribute("title", "Apply for Job");
        model.addAttribute("app", appDao.findOne(appId));

        return "app/apply";
    }

    @RequestMapping(value="apply/{jobId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int appId, @ModelAttribute  @Valid App newApp,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Apply for Job");
            return "app/apply";
        }

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