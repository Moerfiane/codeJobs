////package org.CodeJobs.controllers;
//
//
//import org.CodeJobs.models.Employer;
//import org.CodeJobs.models.data.ApplyDao;
//import org.CodeJobs.models.data.EmpDao;
//import org.CodeJobs.models.data.JobDao;
//import org.CodeJobs.models.data.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("view")
//public class EmployerPortalController {
//
//        @Autowired
//        private EmpDao empDao;
//
//        @Autowired
//        private JobDao jobDao;
//
//        @Autowired
//        private UserDao userDao;
//
//        @Autowired
//        private ApplyDao applyDao;
//
//        @RequestMapping(value = "")
//        public String index(Model model, HttpSession session){
//
//            Integer showEmp = (Integer) session.getAttribute("emp_id");
//            System.out.println(showEmp + "new");
//            model.addAttribute("views", (empDao.session(showEmp)));
//
//            return "view/index";
//        }
//
//        @RequestMapping(value="job", method = RequestMethod.GET)
//        public String viewAppl(Model model) {
//            model.addAttribute("jobTitle", "Add Job Title");
//            model.addAttribute("address", "Add Address");
//            model.addAttribute("jobCategory", "Select Job Category");
//            model.addAttribute("jobSummary", "Add Job Summary");
//            model.addAttribute("location", "Add Location");
//            model.addAttribute("schedule", "Add Schedule");
//            model.addAttribute("positionType", "Add Position Type");
//            model.addAttribute("numOfPositions", "Add Number of Positions");
//            model.addAttribute("dressCode", "Add Dress Code");
//            model.addAttribute("payRate", "Add Pay Rate");
//            model.addAttribute("closingDate", "Add Closing Date");
//            model.addAttribute(new Emp());
//
//        }
//
//        @RequestMapping(value = "viewapplicant", method = RequestMethod.POST)
//        public String processView(@ModelAttribute @Valid Employer newEmp, HttpSession session, Errors errors, Model model) {
//
//            if(errors.hasErrors()){
//                model.addAttribute("jobTitle", "Enter name of job");
//                model.addAttribute("address", "Add Address");
//                model.addAttribute("jobCategory", "Select Job Category");
//                model.addAttribute("jobSummary", "Add Job Summary");
//                model.addAttribute("location", "Add Location");
//                model.addAttribute("schedule", "Add Schedule");
//                model.addAttribute("positionType", "Add Position Type");
//                model.addAttribute("numOfPositions", "Add Number of Positions");
//                model.addAttribute("dressCode", "Add Dress Code");
//                model.addAttribute("payRate", "Add Pay Rate");
//                model.addAttribute("closingDate", "Add Closing Date");
//                return "view/apply";
//            }
//
//            Integer whatever = (Integer) session.getAttribute("emp_id");
//            System.out.println(whatever + " is the session name");
//            newEmp.setSession(whatever);
//
//            empDao.save(newEmp);
//
//            return "redirect:/job";
//        }
//
//
//
//
//
//
//
//    }
