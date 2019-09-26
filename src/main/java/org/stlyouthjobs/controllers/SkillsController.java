package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.data.SkillsDao;

@Controller
@RequestMapping("skills")
public class SkillsController {

    @Autowired
    private SkillsDao skillsDao;

    @RequestMapping(value = "add", method= RequestMethod.GET)
    public String skillsAdd(Model model)
}
