package org.CodeJobs.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
@Controller
public class HomePage {

    @RequestMapping(value = "")
    public String index(){

        return "index";
    }
}
