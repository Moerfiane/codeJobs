package org.CodeJobs.controllers;


import org.CodeJobs.models.Apply;
import org.CodeJobs.models.Job;
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

import org.CodeJobs.models.data.AppDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("apply")
public class ApplicationPortalController
{

    @Autowired
    private AppDao appDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String processIndex(Model model, HttpSession session){
//        Integer identify =(Integer) session.getAttribute("user_id");
//        System.out.println(identify + "new");
////        Integer job_id =(Integer) Job.getJobId();
////        System.out.println(job_id + "is job id");
        model.addAttribute("title", "Edit Job");
        model.addAttribute("jobs", (jobDao.findAll()));

        return "apply/index";
    }

    @RequestMapping(value="index/{jobId}", method = RequestMethod.POST)
    public String processApply(Model model, int jobId, @ModelAttribute @Valid Apply newApply, HttpSession session, Errors errors) {

        if(errors.hasErrors()){
            model.addAttribute("name", "Enter your name");
            return "apply/apply";
        }
        Integer name =(Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        System.out.println(jobId + "is job id");
        newApply.setSession(name);
        newApply.setJob_Id(jobId);
        appDao.save(newApply);

        return "redirect:/apply";
    }




}