package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.Experience;
import org.stlyouthjobs.models.data.ExperienceDao;

import javax.validation.Valid;

@Controller
@RequestMapping("experience")
public class ExperienceController {

    @Autowired
    private ExperienceDao experienceDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Experience");
        model.addAttribute(new Experience());
        return "experience/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Experience experience, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add experience");
            return "experience/add";
        }
        experienceDao.save(experience);
        return "redirect:/cheese";
    }
}

