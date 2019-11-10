package org.CodeJobs.controllers;


import org.CodeJobs.models.Employer;
import org.CodeJobs.models.data.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("view")
public class EmployerPortalController {

        @Autowired
        private EmpDao empDao;

        @RequestMapping(value = "")
        public String index(Model model){

            model.addAttribute("title", "Employer Portal");
            model.addAttribute("views", empDao.findAll());

            return "view/index";
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
            model.addAttribute(new Employer());

            return "view/apply";
        }

        @RequestMapping(value = "apply", method = RequestMethod.POST)
        public String processApply(Model model, @ModelAttribute @Valid Employer newApp, Errors errors) {

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


        @RequestMapping(value="apply/{jobId}", method=RequestMethod.GET)
        public String displayEditJobForm(Model model, @PathVariable int empId) {

            model.addAttribute("title", "Apply for Job");
            model.addAttribute("app", empDao.findOne(empId));

            return "app/apply";
        }

        @RequestMapping(value="apply/{jobId}", method = RequestMethod.POST)
        public String processEditForm(Model model, @PathVariable int empId, @ModelAttribute  @Valid Employer newEmp,
                                      Errors errors) {

            if (errors.hasErrors()) {
                model.addAttribute("title", "Applicants for job");
                return "app/apply";
            }

            Employer applyApp = empDao.findOne(empId);
            applyApp.setJobTitle(newEmp.getJobTitle());
            applyApp.setAddress(newEmp.getAddress());
            applyApp.setJobCategory(newEmp.getJobCategory());
            applyApp.setLocation(newEmp.getLocation());
            applyApp.setSchedule(newEmp.getSchedule());
            applyApp.setJobSummary(newEmp.getJobSummary());
            applyApp.setPositionType(newEmp.getPositionType());
            applyApp.setNumOfPositions(newEmp.getNumOfPositions());
            applyApp.setDressCode(newEmp.getDressCode());
            applyApp.setPayRate(newEmp.getPayRate());
            applyApp.setClosingDate(newEmp.getClosingDate());
            empDao.save(applyApp);

            return "redirect:/app";
        }


    }
