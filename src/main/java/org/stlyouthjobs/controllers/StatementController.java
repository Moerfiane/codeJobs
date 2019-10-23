package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.Statement;
import org.stlyouthjobs.models.data.StatementDao;

import javax.validation.Valid;

@Controller
@RequestMapping("Statement")
public class StatementController {

    @Autowired
    private StatementDao statementDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Skills");
        model.addAttribute(new Statement());
        return "statement/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid Statement newStatement, Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("Statement", "Add Statement");
            return "statement/add";
        }

        statementDao.save(newStatement);
        return "redirect:/skills/add";
    }
}

