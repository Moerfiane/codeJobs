package org.stlyouthjobs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.AboutMe;
import org.stlyouthjobs.models.data.AboutMeDao;

import javax.validation.Valid;

@Controller
@RequestMapping("aboutme")
public class AboutMeController {

    @Autowired
    private AboutMeDao aboutMeDao;


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add About Me");
        model.addAttribute(new AboutMe());
        return "/aboutMe/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid AboutMe aboutMe, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add About Me");
            return "/aboutMe/add";
        }
        aboutMeDao.save(aboutMe);
        return "redirect:/skills/add";
    }

}

