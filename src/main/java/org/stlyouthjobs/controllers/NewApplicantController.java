package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.NewApplicant;
import org.stlyouthjobs.models.data.NewApplicantDao;
import org.stlyouthjobs.models.data.UserDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("newapplicant")
public class NewApplicantController {

    @Autowired
    private NewApplicantDao newApplicantDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping("display")
    public String index(Model model) {

        model.addAttribute("title", "Display Applicants");
        model.addAttribute("applicants", newApplicantDao.findAll());
        return "newapplicant/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Applicant Info");
        model.addAttribute(new NewApplicant());
        return "newapplicant/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid NewApplicant newApplicant, HttpSession session, Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("Applicant Info", "Add Applicant Info");
            return "newapplicant/add";
        }

        Integer name = (Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        newApplicant.setSession(name);

        newApplicantDao.save(newApplicant);
        return "redirect:/statement/add";

    }

    @RequestMapping(value = "edit/{newApplicantId}", method = RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int newApplicantId) {

        model.addAttribute("title", "Edit Applicant");
        model.addAttribute("newApplicant", newApplicantDao.findOne(newApplicantId));

        return "newapplicant/edit";

    }

    @RequestMapping(value = "edit/{newApplicantId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int newApplicantId, @ModelAttribute @Valid
            NewApplicant newApplicant, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Applicant");
            return "newapplicant/edit";
        }

        NewApplicant editedApplicant = newApplicantDao.findOne(newApplicantId);
        editedApplicant.setGitHub(newApplicant.getGitHub());
        editedApplicant.setLinkedIn(newApplicant.getLinkedIn());
        editedApplicant.setName(newApplicant.getName());
        editedApplicant.setPhoneNum(newApplicant.getPhoneNum());
        editedApplicant.setEmail(newApplicant.getEmail());
        newApplicantDao.save(editedApplicant);

        return "redirect:/newapplicant/display";

    }


}
