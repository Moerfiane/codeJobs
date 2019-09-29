package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.CommunityInvolvement;
import org.stlyouthjobs.models.data.CommunityInvolvementDao;
import org.stlyouthjobs.models.data.EducationDao;
import org.stlyouthjobs.models.data.SkillsDao;

import javax.validation.Valid;

@Controller
@RequestMapping("communityInvolvement")
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
        model.addAttribute(new CommunityInvolvement());
        model.addAttribute("volunteer", "Add Volunteer Work");

        return "communityInvolvement/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processCommunityInvolvement(Model model, @ModelAttribute @Valid CommunityInvolvement communityInvolvement, Errors errors){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Community Involvement");
            model.addAttribute("volunteer", "Add Volunteer Work");
            return "communityInvolvement/add";
        }
        communityInvolvementDao.save(communityInvolvement);

        return "redirect:";
    }
}
