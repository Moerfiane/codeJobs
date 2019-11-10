package org.CodeJobs.controllers;


import org.CodeJobs.models.data.ApplyDao;
import org.CodeJobs.models.data.JobDao;
import org.CodeJobs.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("applicant")
public class ApplicantController {

    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="applicant/{applyId}", method = RequestMethod.GET)
    public String applied(Model model, @PathVariable int applyId, HttpSession session){
        model.addAttribute("apply", (applyDao.findOne(applyId)));

        return "apply/applicant";
    }
}
