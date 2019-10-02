package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stlyouthjobs.models.data.AnswerDao;
import org.stlyouthjobs.models.data.CompareDao;
import org.stlyouthjobs.models.data.QuestionDao;

@Controller
@RequestMapping(value = "compare")
public class CompareController {


    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private CompareDao compareDao;

    @Autowired
    private AnswerDao answerDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Score");
        model.addAttribute("compares", compareDao.findAll());
        return "compare/index";
    }

//    @RequestMapping(value = "add", method = RequestMethod.GET)
//    public String add(Model model) {
//        model.addAttribute("title", "Add Menu");
//        model.addAttribute(new Compare());
//        return "menu/add";
//    }
//
//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String add(Model model, @ModelAttribute @Valid Compare newMenu, Errors errors) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Menu");
//            return "menu/add";
//        }
//
//        compareDao.save(newCompare);
//        return "redirect:view/" + newMenu.getId();
//    }
//
//    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
//    public String view(Model model, @PathVariable int id) {
//
//        Compare menu = compareDao.findOne(id);
//
//        model.addAttribute("title", menu.getName());
//        model.addAttribute("menu", menu);
//        return "menu/view";
//    }
//
//    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.GET)
//    public String addItem(Model model, @PathVariable int menuId) {
//        Compare menu = compareDao.findOne(menuId);
//        AddMenuItemForm itemForm = new AddMenuItemForm(menu, questionDao.findAll());
//        model.addAttribute("title", "add item to menu");
//        model.addAttribute("form", itemForm);
//        return "menu/add-item";
//    }
//
//    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.POST)
//    public String addItem(Model model, @ModelAttribute @Valid AddMenuItemForm itemForm, Errors errors, @PathVariable int menuId) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add item");
//            return "menu/add-item/" + menuId;
//        }
//
//        Compare menu = compareDao.findOne(itemForm.getMenuId());
//        Question cheese = questionDao.findOne(itemForm.getCheeseId());
//        compare.addItem(questionDao);
//        compareDao.save(menu);
//        return "redirect:../view/" + menu.getId();
//    }
//    @RequestMapping(value = "remove", method = RequestMethod.GET)
//    public String displayRemoveMenuForm(Model model) {
//        model.addAttribute("menus", compareDao.findAll());
//        model.addAttribute("title", "Remove Menu");
//        return "menu/remove";
//
//    }
//
//    @RequestMapping(value = "remove", method = RequestMethod.POST)
//    public String processRemoveMenuForm(@RequestParam int[] menuIds) {
//
//        for (int menuId : menuIds) {
//            compareDao.delete(menuId);
//        }
//
//        return "redirect:/menu";
//    }
//    @RequestMapping(value = "edit/{menuId}", method = RequestMethod.GET)
//    public String displayEditMenuForm(Model model, @PathVariable int menuId) {
//
//        model.addAttribute("title", "Edit Menu");
//        model.addAttribute("menu", compareDao.findOne(menuId));
//        return "menu/edit";
//    }
//
//    @RequestMapping(value = "edit/{menuId}", method = RequestMethod.POST)
//    public String processEditForm(Model model, @PathVariable int menuId, @ModelAttribute  @Valid Compare newMenu,
//                                  Errors errors) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Menu");
//            return "menu/edit";
//        }
//
//        Compare editedMenu = compareDao.findOne(menuId);
//        editedMenu.setName(newMenu.getName());
//        compareDao.save(editedMenu);
//
//        return "redirect:/menu";
//    }
}