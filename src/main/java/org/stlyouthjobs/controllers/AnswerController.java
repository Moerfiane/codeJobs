package org.stlyouthjobs.controllers;

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

import javax.validation.Valid;

@Controller
@RequestMapping("answer")
public class AnswerController {

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private QuestionDao questionDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("answers", answerDao.findAll());
        model.addAttribute("title", "Answers");

        return "category/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String adds(Model model) {

        model.addAttribute("title", "Add Answer");
        model.addAttribute("answer", new Answer());
        return "answer/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String adds(Model model, @ModelAttribute @Valid Answer answer, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Answer");
            return "category/add";
        }
        answerDao.save(answer);
        return "redirect:/category";
    }
}
//    @RequestMapping(value = "remove", method = RequestMethod.GET)
//    public String displayRemoveCategoryForm(Model model) {
//        model.addAttribute("categories", answerDao.findAll());
//        model.addAttribute("title", "Remove Category");
//        model.addAttribute("cheeses", questionDao.findAll());
//        model.addAttribute("title", "Remove Cheese");
//        return "category/remove";
//
//    }
//
//    @RequestMapping(value = "remove", method = RequestMethod.POST)
//    public String processRemoveCategoryForm(@RequestParam int[] categoryIds) {
//
//        for (int categoryId : categoryIds) {
//            answerDao.delete(categoryId);
//        }
//
//        return "redirect:/category";
//    }

//    @RequestMapping(value = "edit/{categoryId}", method = RequestMethod.GET)
//    public String displayEditCategoryForm(Model model, @PathVariable int categoryId) {
//
//        model.addAttribute("title", "Edit Category");
//        model.addAttribute("category", answerDao.findOne(categoryId));
//        return "category/edit";
//    }
//
//    @RequestMapping(value = "edit/{categoryId}", method = RequestMethod.POST)
//    public String processEditForm(Model model, @PathVariable int categoryId, @ModelAttribute @Valid Answer newCategory,
//                                  Errors errors) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Category");
//            return "category/edit";
//        }
//
//        Answer editedCategory = answerDao.findOne(categoryId);
//        editedCategory.setName(newCategory.getName());
//        answerDao.save(editedCategory);
//
//        return "redirect:/category";
//    }
//}