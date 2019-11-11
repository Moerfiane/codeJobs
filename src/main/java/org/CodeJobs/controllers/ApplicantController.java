package org.CodeJobs.controllers;


import org.CodeJobs.models.Apply;
import org.CodeJobs.models.Job;
import org.CodeJobs.models.data.ApplyDao;
import org.CodeJobs.models.data.JobDao;
import org.CodeJobs.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("applicant")
public class ApplicantController {

    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserDao userDao;

//    @RequestMapping(value="")
//    public String processIndex(Model model, HttpSession session){
//        model.addAttribute("applies", (applyDao.findAll()));
//        return "applicant/index";
//    }

    @RequestMapping(value="")
    public String index(Model model, HttpSession session){
        Integer userSession =(Integer) session.getAttribute("user_id");
        System.out.println(userSession + "new");
        model.addAttribute("applies", (applyDao.session(userSession)));

        return "applicant/index";
    }
}
