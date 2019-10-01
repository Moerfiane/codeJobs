package org.stlyouthjobs.controllers;

import org.stlyouthjobs.models.Answer;
import org.stlyouthjobs.models.Question;
import org.stlyouthjobs.models.data.AnswerDao;
import org.stlyouthjobs.models.data.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private AnswerDao answerDao;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("questions", questionDao.findAll());
        model.addAttribute("title", "Quiz");

        return "question/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddQuestionForm(Model model) {
        model.addAttribute("title", "Add Question");
        model.addAttribute(new Question());
        model.addAttribute("title", "Add Answer");
        model.addAttribute(new Answer());
        return "question/add";
}

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(Model model , @ModelAttribute  @Valid Question newQuestion,  @ModelAttribute  @Valid Answer newAnswer, Errors errors) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add question");
            return "question/add";
        }

        answerDao.save(newAnswer);
        questionDao.save(newQuestion);
        return "redirect:/question";
    }

//    @RequestMapping(value = "remove", method = RequestMethod.GET)
//    public String displayRemoveCheeseForm(Model model) {
//        model.addAttribute("cheeses", questionDao.findAll());
//        model.addAttribute("title", "Remove Cheese");
//        return "cheese/remove";
//    }

//    @RequestMapping(value = "remove", method = RequestMethod.POST)
//    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {
//
//        for (int cheeseId : cheeseIds) {
//            questionDao.delete(cheeseId);
//        }
//
//        return "redirect:/cheese";
//    }
//    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
//    public String displayEditCheeseForm(Model model, @PathVariable int cheeseId) {
//
//        model.addAttribute("title", "Edit Cheese");
//        model.addAttribute("cheese", questionDao.findOne(cheeseId));
//        model.addAttribute("categories", answerDao.findAll());
//        return "cheese/edit";
//    }

//    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
//    public String processEditForm(Model model, @PathVariable int cheeseId, @ModelAttribute  @Valid Question newCheese, @RequestParam int categoryId,
//                                  Errors errors) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Cheese");
//            return "cheese/edit";
//        }
//
//        Question editedCheese = questionDao.findOne(cheeseId);
//        editedCheese.setName(newCheese.getName());
//        editedCheese.setDescription(newCheese.getDescription());
//        editedCheese.setCategory(answerDao.findOne(categoryId));
//        questionDao.save(editedCheese);
//
//        return "redirect:/cheese";
//    }


}