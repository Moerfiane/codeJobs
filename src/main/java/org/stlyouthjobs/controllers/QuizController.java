package org.stlyouthjobs.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("title", "Quiz");

        return("quiz/index");

    }



}
