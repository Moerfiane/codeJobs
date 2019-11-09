package org.CodeJobs.controllers;


import org.CodeJobs.models.Applicant;
import org.CodeJobs.models.Apply;
import org.CodeJobs.models.Job;
import org.CodeJobs.models.data.ApplicantDao;
import org.CodeJobs.models.data.JobDao;
import org.CodeJobs.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import org.CodeJobs.models.data.ApplyDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("apply")
public class ApplicationPortalController
{

    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ApplicantDao applicantDao;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String processIndex(Model model, HttpSession session){
//        Integer identify =(Integer) session.getAttribute("user_id");
//        System.out.println(identify + "new");
////        Integer job_id =(Integer) Job.getJobId();
////        System.out.println(job_id + "is job id");
        model.addAttribute("jobs", (jobDao.findAll()));

        return "apply/index";
    }

    @RequestMapping(value="job/{jobId}", method = RequestMethod.GET)
    public String processjob(Model model, @PathVariable int jobId, HttpSession session){
        model.addAttribute("jobs", (jobDao.findOne(jobId)));

        return "apply/job";
    }

    @RequestMapping(value="job/{jobId}", method = RequestMethod.POST)
    public String processApply(@PathVariable int jobId, @ModelAttribute Job job, @ModelAttribute @Valid Apply newApply, HttpSession session,
                               Errors errors, Model model) {

        if(errors.hasErrors()){
            model.addAttribute("name", "Enter your name");
            return "apply/apply";
        }

        Job newJob = jobDao.findOne(jobId);
        Integer name =(Integer) session.getAttribute("user_id");
        newApply.setSession(name);
        newApply.setJob_Id(newJob.getId());
        applyDao.save(newApply);

        return "redirect:/apply";
    }

    @RequestMapping(value="apply/{applyId}", method = RequestMethod.GET)
    public String applied(Model model, @PathVariable int applicantId, HttpSession session){
        model.addAttribute("applied", (applyDao.findOne(applicantId)));

        return "applicant";
    }

    @RequestMapping(value="apply/{applyId}", method = RequestMethod.POST)
    public String jobber(@PathVariable int applyId, @ModelAttribute Apply apply, @ModelAttribute Applicant applicant, @ModelAttribute @Valid Job newJob, HttpSession session,
                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("name", "Enter your name");
            return "apply/applicant";
        }

        //Applicant newApplicant = applicantDao.findOne(applyId);
        Apply newApply = applyDao.findOne(applyId);
        Integer name = (Integer) session.getAttribute("user_id");
        newJob.setSession(name);
        newJob.setApply_Id(newApply.getId());
        jobDao.save(newJob);

        return "redirect:/applicant";
    }
}