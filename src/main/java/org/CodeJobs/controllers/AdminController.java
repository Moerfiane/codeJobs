package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stlyouthjobs.models.data.EducationDao;
import org.stlyouthjobs.models.data.JobDao;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    JobDao jobDao;

    @Autowired
    EducationDao educationDao;

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
    public String educationIndex(Model model) {

        model.addAttribute("title", "Admin: Education Listings");
        model.addAttribute("education", educationDao.findAll());

        return "admin/education";

    }

}
