package org.CodeJobs.controllers;


import org.CodeJobs.models.App;
import org.CodeJobs.models.Job;
import org.CodeJobs.models.data.JobDao;
import org.CodeJobs.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.CodeJobs.models.data.AppDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("app")
public class ApplicationPortalController
{

    @Autowired
    private AppDao appDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "")
    public String index(Model model, HttpSession session){
            Integer identify =(Integer) session.getAttribute("user_id");
            System.out.println(identify + "new");
            model.addAttribute("title", "Application Portal");
            model.addAttribute("apps", jobDao.findAll());

        return "app/index";
    }

    @RequestMapping(value="apply", method = RequestMethod.GET)
    public String applyJob(Model model) {

        model.addAttribute("name", "Enter your name");
        model.addAttribute(new App());

        return "app/apply";
    }

    @RequestMapping(value = "apply", method = RequestMethod.POST)
    public String processApply(Model model, @ModelAttribute @Valid App newApp, HttpSession session, Errors errors) {

        if(errors.hasErrors()){
            model.addAttribute("name", "Enter your name");
            return "app/apply";
        }
        Integer name =(Integer) session.getAttribute("user_id");
        Integer job_id =(Integer) Job.getId("job_id");
        System.out.println(name +" is session name");
        newApp.setSession(name);
        newApp.setJob_Id(job_id);
        appDao.save(newApp);

        return "redirect:/app";
    }




}