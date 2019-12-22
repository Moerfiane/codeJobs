package org.CodeJobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.CodeJobs.models.Statement;
import org.CodeJobs.models.data.StatementDao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("statement")
public class StatementController {

    @Autowired
    private StatementDao statementDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Display Statements");
        model.addAttribute("statements", statementDao.findAll());

        return "statement/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add Statement");
        model.addAttribute(new Statement());
        return "statement/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model , @ModelAttribute @Valid Statement newStatement, Errors errors, HttpSession session){
        if (errors.hasErrors()) {
            model.addAttribute("Statement", "Add Statement");
            return "statement/add";
        }

        Integer name = (Integer) session.getAttribute("user_id");
        System.out.println(name +" is session name");
        newStatement.setSession(name);

        statementDao.save(newStatement);
        return "redirect:/skills/add";

    }

    @RequestMapping(value = "edit/{statementId}", method = RequestMethod.GET)
    public String displayEditStatementForm(Model model, @PathVariable int statementId) {

        model.addAttribute("title", "Edit Statement");
        model.addAttribute("statement", statementDao.findOne(statementId));

        return "statement/edit";

    }

    @RequestMapping(value = "edit/{statementId}", method = RequestMethod.POST)
    public String processStatementForm(Model model, @PathVariable int statementId, @ModelAttribute
    @Valid Statement newStatement, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Statement");
            return "statement/edit";
        }

        Statement editedStatement = statementDao.findOne(statementId);
        editedStatement.setDescription(newStatement.getDescription());
        statementDao.save(editedStatement);

        return "redirect:/statement/";

    }
}


