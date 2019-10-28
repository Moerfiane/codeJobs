package org.CodeJobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.CodeJobs.models.Skills;
import org.CodeJobs.models.data.SkillsDao;
import org.CodeJobs.models.data.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("skills")
public class SkillsController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SkillsDao skillsDao;

    @RequestMapping(value="")
    public String index(Model model, HttpSession session, HttpServletRequest request){
        model.addAttribute("skills", (skillsDao.findAll()));

        return "skills/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Skills");
        model.addAttribute(new Skills());
        return "skills/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid Skills newSkills, HttpSession session, Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("skills", "Add Skills");
            return "skills/add";
        }

        Integer name =(Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        newSkills.setSession(name);

        skillsDao.save(newSkills);
        return "redirect:/projectexperience/add";
    }

    @RequestMapping(value="edit/{skillsId}", method=RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int skillsId) {

        model.addAttribute("title", "Edit Skill");
        model.addAttribute("skills", skillsDao.findOne(skillsId));

        return "skills/edit";
    }

    @RequestMapping(value="edit/{skillsId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int skillsId, @ModelAttribute  @Valid Skills newSkills,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "skills/edit";
        }

        Skills editedSkills = skillsDao.findOne(skillsId);
        editedSkills.setLanguage1(newSkills.getLanguage1());
        editedSkills.setLanguage2(newSkills.getLanguage2());
        editedSkills.setLanguage3(newSkills.getLanguage3());
        editedSkills.setLanguage4(newSkills.getLanguage4());
        editedSkills.setLanguage5(newSkills.getLanguage5());
        editedSkills.setLanguage6(newSkills.getLanguage6());
        editedSkills.setFramework1(newSkills.getFramework1());
        editedSkills.setFramework2(newSkills.getFramework2());
        editedSkills.setFramework3(newSkills.getFramework3());
        editedSkills.setFramework4(newSkills.getFramework4());
        editedSkills.setFramework5(newSkills.getFramework5());
        editedSkills.setFramework6(newSkills.getFramework6());
        editedSkills.setDatabase1(newSkills.getDatabase1());
        editedSkills.setDatabase2(newSkills.getDatabase2());
        editedSkills.setDatabase3(newSkills.getDatabase3());
        editedSkills.setTool1(newSkills.getTool1());
        editedSkills.setTool2(newSkills.getTool2());
        editedSkills.setTool3(newSkills.getTool3());

        skillsDao.save(editedSkills);

        return "redirect:/skills";
    }
}
