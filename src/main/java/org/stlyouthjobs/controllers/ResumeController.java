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

    @RequestMapping(value = "")
    public String index(Model model, HttpSession session) {
        Integer user = (Integer) session.getAttribute("user_id");
        System.out.println(user + "new");
        model.addAttribute("statements", (statementDao.findOne(user)));
        model.addAttribute("skills", (skillsDao.findOne(user)));
        model.addAttribute("projectExperiences", (projectExperienceDao.findOne(user)));
        model.addAttribute("workExperiences", (workExperienceDao.findOne(user)));
        model.addAttribute("educations", (educationDao.findOne(user)));
        model.addAttribute("newApplicants", (newApplicantDao.findOne(user)));

        return "resume/index";
    }
        @RequestMapping(value = "final")
        public String processFinal (Model model, HttpSession session){
            Integer user = (Integer) session.getAttribute("user_id");
            System.out.println(user + "new");
            model.addAttribute("statements", (statementDao.findOne(user)));
            model.addAttribute("skills", (skillsDao.findOne(user)));
            model.addAttribute("projectExperiences", (projectExperienceDao.findOne(user)));
            model.addAttribute("workExperiences", (workExperienceDao.findOne(user)));
            model.addAttribute("educations", (educationDao.findOne(user)));
            model.addAttribute("newApplicants", (newApplicantDao.findOne(user)));

            return "resume/final";
        }
    }

