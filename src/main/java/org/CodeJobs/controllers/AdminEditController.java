package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.Job;
import org.stlyouthjobs.models.data.EducationDao;
import org.stlyouthjobs.models.data.JobDao;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "admin")
public class AdminEditController {

    @Autowired
    JobDao jobDao;

    @Autowired
    EducationDao educationDao;

    @RequestMapping(value="edit/{jobId}", method= RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int jobId) {

        model.addAttribute("title", "Edit Job");
        model.addAttribute("job", jobDao.findOne(jobId));

        return "job/edit";
    }

    @RequestMapping(value="edit/{jobId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int jobId, @ModelAttribute @Valid Job newJob,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "job/edit";
        }

        Job editedJob = jobDao.findOne(jobId);
        editedJob.setJobTitle(newJob.getJobTitle());
        editedJob.setAddress(newJob.getAddress());
        editedJob.setJobCategory(newJob.getJobCategory());
        editedJob.setLocation(newJob.getLocation());
        editedJob.setSchedule(newJob.getSchedule());
        editedJob.setJobSummary(newJob.getJobSummary());
        editedJob.setPositionType(newJob.getPositionType());
        editedJob.setNumOfPositions(newJob.getNumOfPositions());
        editedJob.setDressCode(newJob.getDressCode());
        editedJob.setPayRate(newJob.getPayRate());
        editedJob.setClosingDate(newJob.getClosingDate());
        jobDao.save(editedJob);

        return "redirect:/job";
    }

}
