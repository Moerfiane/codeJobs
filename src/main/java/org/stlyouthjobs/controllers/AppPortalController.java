package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.AppPortal;
import org.stlyouthjobs.models.data.AppPortalDao;

import javax.validation.Valid;

@Controller
@RequestMapping("appPortal")
public class AppPortalController {

    @Autowired
    private AppPortalDao appPortalDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("appPortals", appPortalDao.findAll());
        model.addAttribute("title", "Apply");
        return "appPortal/apply";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Apply for Job");
        model.addAttribute("name", "Enter your name");
        model.addAttribute("jobTitle", "Enter or select Job Title");

        model.addAttribute(new AppPortal());

        return "appPortal/apply";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model, @ModelAttribute @Valid AppPortal newAppPortal, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("name", "Enter your name");
            model.addAttribute("jobTitle", "Enter or select Job Title");

            return "appPortal/apply";
        }
        appPortalDao.save(newAppPortal);

        return "redirect:/appPortal";
    }

}
