//package org.stlyouthjobs.controllers;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.stlyouthjobs.models.Address;
//import org.stlyouthjobs.models.data.EmployerAddressDao;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("employerAddress")
//public class EmployerAddressController {
//
//    @Autowired
//    private EmployerAddressDao employerAddressDao;
//
//    @RequestMapping(value = "add", method = RequestMethod.GET)
//    public String add(Model model) {
//        model.addAttribute("streetNumber", "Street Number");
//        model.addAttribute("streetName", "Street Name");
//        model.addAttribute("city", "City");
//        model.addAttribute("zipCode", "Zip Code");
//        model.addAttribute("neighborhood", "Neighborhood");
//        model.addAttribute(new Address());
//
//        return "newemployer/add";
//    }
//
//    @RequestMapping(value="add", method= RequestMethod.POST)
//    public String employerAddy (Model model, @ModelAttribute @Valid Address address, Errors errors) {
//        if (errors.hasErrors()) {
//            model.addAttribute("streetNumber", "Street Number");
//            model.addAttribute("streetName", "Street Name");
//            model.addAttribute("city", "City");
//            model.addAttribute("zipCode", "Zip Code");
//            model.addAttribute("neighborhood", "Neighborhood");
//            return "newemployer/add";
//        }
//        employerAddressDao.save(address);
//        return "redirect:/addNewJob";
//    }
//}
//
