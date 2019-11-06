package org.CodeJobs.controllers;

import org.CodeJobs.models.Education;
import org.CodeJobs.models.data.EducationDao;
import org.CodeJobs.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.attribute.standard.PresentationDirection;
import javax.validation.constraints.Null;

@Controller
@RequestMapping(value = "admin")
public class AdminSearchController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "search")
    public String index(Model model) {

        model.addAttribute("title", "Search");

        return "admin/search";

    }

    @RequestMapping(value = "results")
    public String search(@RequestParam String searchTerm, Model model) {

        model.addAttribute("title", "Search for User");
        model.addAttribute("results", userDao.findByUsername(searchTerm));

        return "admin/searchresults";

    }

}
