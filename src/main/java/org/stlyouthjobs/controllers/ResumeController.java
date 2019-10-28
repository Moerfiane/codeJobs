package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.*;
import org.stlyouthjobs.models.data.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("resume")
public class ResumeController {

        @Autowired
        private StatementDao statementDao;

        @Autowired
        private SkillsDao skillsDao;

        @Autowired
        private ProjectExperienceDao projectExperienceDao;

        @Autowired
        private WorkExperienceDao workExperienceDao;

        @Autowired
        private EducationDao educationDao;

        @Autowired
        private NewApplicantDao newApplicantDao;

        @RequestMapping(value="")
        public String index(Model model, HttpSession session){
            Integer user =(Integer) session.getAttribute("user_id");
            System.out.println(user + "new");
            model.addAttribute("statements", (statementDao.findOne(user)));
            model.addAttribute("skills", (skillsDao.findOne(user)));
            model.addAttribute("projectExperiences", (projectExperienceDao.findOne(user)));
            model.addAttribute("workExperiences", (workExperienceDao.findOne(user)));
            model.addAttribute("educations", (educationDao.findOne(user)));
            model.addAttribute("newApplicants", (newApplicantDao.findOne(user)));

        return "resume/index";
    }
}

//        @RequestMapping(value = "add", method = RequestMethod.GET)
//        public String add(Model model) {
//            model.addAttribute("organizationName", "Organization Name");
//            model.addAttribute("contactName", "Contact Name");
//            model.addAttribute("website", "Website");
//            model.addAttribute("ein", "EIN");
//            model.addAttribute("phoneNumber", "Phone Number");
//            model.addAttribute(new NewEmployer());
//            model.addAttribute("streetNumber", "Street Number");
//            model.addAttribute("streetName", "Street Name");
//            model.addAttribute("city", "City");
//            model.addAttribute("zipCode", "Zip Code");
//            model.addAttribute("neighborhood", "Neighborhood");
//            model.addAttribute(new Address());
//
//            return "newemployer/add";
//        }
//
//        @RequestMapping(value="add", method= RequestMethod.POST)
//        public String employerRegisterForm (Model model, @ModelAttribute("newemployer") @Valid NewEmployer newEmployer, @ModelAttribute Address address, Errors errors) {
//            if (errors.hasErrors()) {
//                model.addAttribute("organizationName", "Organization Name");
//                model.addAttribute("contactName", "Contact Name");
//                model.addAttribute("website", "Website");
//                model.addAttribute("ein", "EIN");
//                model.addAttribute("phoneNumber", "Phone Number");
//                model.addAttribute(new NewEmployer());
//                model.addAttribute("streetNumber", "Street Number");
//                model.addAttribute("streetName", "Street Name");
//                model.addAttribute("city", "City");
//                model.addAttribute("zipCode", "Zip Code");
//                model.addAttribute("neighborhood", "Neighborhood");
//                model.addAttribute(new Address());
//                return "newemployer/add";
//            }
//
//            newEmployerDao.save(newEmployer);
//            addressDao.save(address);
//
//
//            return "redirect:address/add";
//        }



