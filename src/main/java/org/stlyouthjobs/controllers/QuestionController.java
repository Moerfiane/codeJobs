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
import org.springframework.web.bind.annotation.RequestParam;
import org.stlyouthjobs.models.Answer;
import org.stlyouthjobs.models.Question;
import org.stlyouthjobs.models.data.AnswerDao;
import org.stlyouthjobs.models.data.QuestionDao;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"question"})
public class QuestionController {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;

    @RequestMapping({""})
    public String index(Model model) {

        model.addAttribute("questions", this.questionDao.findAll());
        model.addAttribute("title", "Quiz");
        model.addAttribute("answer", this.answerDao.findAll());
        return "question/index";
    }

    @RequestMapping(
            value = {"adda"},
            method = {RequestMethod.GET}
    )
    public String displayAddAnswerForm(Model model) {
        model.addAttribute("title", "Add Q&A");
        model.addAttribute(new Answer());
        model.addAttribute("list", this.answerDao.findAll());
        model.addAttribute("questions", questionDao.findAll());
        return "question/adda";
    }

/*    @RequestMapping(
            value = {"adda"},
            method = {RequestMethod.POST}
    )
    public String processAddAForm(Model model, @ModelAttribute @Valid Answer newAnswer, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Answer");
            return "question/adda";
        } else {
            this.answerDao.save(newAnswer);
            }
            return "redirect:/question";
        }*/


    @RequestMapping(
            value = {"adda"},
            method = {RequestMethod.POST}
    )
    public String processAddAForm(@ModelAttribute @Valid Answer newAnswer, Errors errors,
                                  @RequestParam int questionId, Model model) {

        Question ques = questionDao.findOne(questionId);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Answer");
            return "question/adda";
        } else {
            newAnswer.setQuestion(ques);
            this.answerDao.save(newAnswer);
        }
        return "redirect:/question";
    }

/*        ==============*/

    @RequestMapping(
            value = {"addq"},
            method = {RequestMethod.GET}
    )
    public String displayAddQuestionForm(Model model) {
        model.addAttribute("title", "Add Q&A");
        model.addAttribute(new Question());
        model.addAttribute("list", this.questionDao.findAll());
        return "question/add";
    }

    @RequestMapping(
            value = {"addq"},
            method = {RequestMethod.POST}
    )

    public String processAddQForm(Model model, @ModelAttribute @Valid Question newQuestion, Answer newAnswer, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Question");
            return "question/add";
        } else {
            this.questionDao.save(newQuestion);
        }
        return "redirect:/question";
    }

    @RequestMapping(
            value = {"remove"},
            method = {RequestMethod.GET}
    )
    public String removeQA(Model model) {
        model.addAttribute("title", "Remove Q&A");
        return "question/remove";
    }

//    =======

}