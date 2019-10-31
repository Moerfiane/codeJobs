package org.CodeJobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.CodeJobs.models.data.*;

import javax.servlet.http.HttpSession;

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

