//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.stlyouthjobs.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.Answer;
import org.stlyouthjobs.models.data.AnswerDao;
import org.stlyouthjobs.models.data.QuestionDao;

@Controller
@RequestMapping({"answer"})
public class AnswerController {
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private QuestionDao questionDao;

    public AnswerController() {
    }

    @RequestMapping({""})
    public String index(Model model) {
        model.addAttribute("answer", this.answerDao.findAll());
        model.addAttribute("title", "Answer");
        return "category/index";
    }

    @RequestMapping(
            value = {"add"},
            method = {RequestMethod.GET}
    )
    public String adds(Model model) {
        model.addAttribute("title", "Add Answer");
        model.addAttribute("answer", new Answer());
        return "answer/add";
    }

    @RequestMapping(
            value = {"add"},
            method = {RequestMethod.POST}
    )
    public String adds(Model model, @ModelAttribute @Valid Answer answer, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Answer");
            return "category/add";
        } else {
            this.answerDao.save(answer);
            return "redirect:/category";
        }
    }
}