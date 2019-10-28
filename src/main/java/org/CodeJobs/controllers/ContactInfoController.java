package org.CodeJobs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.CodeJobs.models.ContactInfo;
import org.CodeJobs.models.data.ContactDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("contactinfo")
public class ContactInfoController {

    @Autowired
    private ContactDao contactDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Contact");
        model.addAttribute(new ContactInfo());
        return "contactInfo/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid ContactInfo newcontactInfo, HttpSession session, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Contact");
            return "contactInfo/add";
        }
        Integer name =(Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        newcontactInfo.setSession(name);

        contactDao.save(newcontactInfo);
        return "redirect:/address/add";
    }

}