package org.CodeJobs.controllers;

import org.CodeJobs.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    JobDao jobDao;

    @Autowired
    EducationDao educationDao;

    @Autowired
    WorkExperienceDao workExperienceDao;

    @Autowired
    StatementDao statementDao;

    @Autowired
    SkillsDao skillsDao;

    @Autowired
    ProjectExperienceDao projectExperienceDao;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Administrator Portal");

        return "admin/index";

    }

    @RequestMapping(value = "job")
    public String jobIndex(Model model) {

        model.addAttribute("title", "Admin: Job Listings");
        model.addAttribute("jobs", jobDao.findAll());

        return "admin/job";

    }

    @RequestMapping(value = "education")
    public String educationIndex(Model model, HttpSession session) {
/*

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);*/

/*

        Integer username =(Integer) session.getAttribute("user_id");
        System.out.println(username + "new");
        model.addAttribute("jobs", (jobDao.session(username)));
*/


        model.addAttribute("title", "Admin: Education Listings");
        model.addAttribute("education", educationDao.findAll());
        model.addAttribute("user", userDao.findAll());

        return "admin/education";

    }

    @RequestMapping(value = "workexperience")
    public String indexWorkExperience(Model model) {

        model.addAttribute("title", "Admin: Work Experience");
        model.addAttribute("workExperience", workExperienceDao.findAll());

        return "admin/workexperience";

    }

    @RequestMapping(value = "statement")
    public String indexStatement(Model model) {
        model.addAttribute("title", "Admin: Statements");
        model.addAttribute("statements", statementDao.findAll());
        model.addAttribute("user", userDao.findAll());

        return "admin/statement";
    }

    @RequestMapping(value = "skills")
    public String indexSkills(Model model, HttpSession session, HttpServletRequest request) {

        model.addAttribute("title", "Admin: Skills");
        model.addAttribute("skills", skillsDao.findAll());

        return "admin/skills";
    }

    @RequestMapping(value = "projectexperience")
    public String indexProjectExperience(Model model) {

        model.addAttribute("title", "Admin: Project Experience");
        model.addAttribute("projectExperience", projectExperienceDao.findAll());

        return "admin/projectexperience";

    }

    @RequestMapping(value = "users")
    public String indexUsers(Model model) {

        model.addAttribute("title", "Admin: Users");
        model.addAttribute("users", userDao.findAll());

        return "admin/users";

    }
}