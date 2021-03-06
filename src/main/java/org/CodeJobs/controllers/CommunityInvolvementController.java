package org.CodeJobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.CodeJobs.models.CommunityInvolvement;
import org.CodeJobs.models.data.CommunityInvolvementDao;
import org.CodeJobs.models.data.EducationDao;
import org.CodeJobs.models.data.SkillsDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("communityinvolvement")
public class CommunityInvolvementController {

    @Autowired
    private CommunityInvolvementDao communityInvolvementDao;

    @Autowired
    private SkillsDao skillsDao;

    @Autowired
    private EducationDao educationDao;


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addCommunityInvolvement(Model model){
        model.addAttribute("title", "Add Community Involvement");
        model.addAttribute("startDate", "Add Start Date");
        model.addAttribute("endDate", "Add End Date");
        model.addAttribute(new CommunityInvolvement());
        model.addAttribute("description", "Add Volunteer Work Description");

        return "communityInvolvement/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processCommunityInvolvement(Model model, @ModelAttribute @Valid CommunityInvolvement communityInvolvement, HttpSession session, Errors errors){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Community Involvement");
            model.addAttribute("startDate", "Add Start Date");
            model.addAttribute("endDate", "Add End Date");
            model.addAttribute("description", "Add Volunteer Work Description");
            return "communityInvolvement/add";
        }

        Integer name =(Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        communityInvolvement.setSession(name);

        communityInvolvementDao.save(communityInvolvement);
        return "redirect:/job";
    }
}
