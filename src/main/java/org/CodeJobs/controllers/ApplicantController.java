//package org.CodeJobs.controllers;
//
//
//import org.CodeJobs.models.data.ApplyDao;
//import org.CodeJobs.models.data.JobDao;
//import org.CodeJobs.models.data.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.websocket.server.PathParam;
//
//@Controller
//@RequestMapping("applicant")
//public class ApplicantController {
//
//    @Autowired
//    private ApplyDao applyDao;
//
//    @Autowired
//    private JobDao jobDao;
//
//    @Autowired
//    private UserDao userDao;
//
////    @RequestMapping(value="")
////    public String processIndex(Model model, HttpSession session){
////        model.addAttribute("applies", (applyDao.findAll()));
////        return "applicant/index";
////    }
//
//    @RequestMapping(value="")
//    public String index(@PathParam("Apply.getJob_Id") Integer jobId,Model model){
//        System.out.println(jobId + "new");
//        model.addAttribute("applies", (applyDao.session(jobId)));
//        return "applicant/index";
//    }
//}
