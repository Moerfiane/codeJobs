package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.CandL;
import org.stlyouthjobs.models.data.CandLDao;

import javax.validation.Valid;


@Controller
@RequestMapping("certificates")
public class CandLController {

    @Autowired
    private CandLDao candlDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Certificates and Licenses.");
        model.addAttribute(new CandL());
        return "certificates/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid CandL newcandl, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Certificates and Licenses.");
            return "certificates/add";
        }
        candlDao.save(newcandl);
        return "redirect:/experience/add";
    }
}
