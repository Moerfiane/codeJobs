package org.stlyouthjobs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.forms.RegisterForm;

@Controller
public class IndexController extends AbstractController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String registerApplicantForm(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("title", "Register");
        return "";

    }

}