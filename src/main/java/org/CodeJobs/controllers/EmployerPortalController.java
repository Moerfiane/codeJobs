package org.CodeJobs.controllers;


import org.CodeJobs.models.Employer;
import org.CodeJobs.models.data.EmpDao;
import org.CodeJobs.models.data.JobDao;
import org.CodeJobs.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("view")
public class EmployerPortalController {

        @Autowired
        private EmpDao empDao;

        @Autowired
        private JobDao jobDao;

        @Autowired
        private UserDao userDao;

        @RequestMapping(value = "")
        public String index(Model model, HttpSession session){

            //model.addAttribute("title", "Employer Portal");
            model.addAttribute("views", jobDao.findAll());

            return "view/index";
        }



        @RequestMapping(value = "viewapplicant", method = RequestMethod.POST)
        public String processView(Model model, @ModelAttribute @Valid Employer newApp, Errors errors) {

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
                return "view/apply";
            }
            empDao.save(newApp);

            return "redirect:/app";
        }







    }
