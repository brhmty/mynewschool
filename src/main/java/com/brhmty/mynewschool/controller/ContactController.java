package com.brhmty.mynewschool.controller;

import com.brhmty.mynewschool.service.ContactService;
import com.brhmty.mynewschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;

@Slf4j
@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @RequestMapping(value={"contact"})
    public String displayContactPage(Model model){
        model.addAttribute("contact", new Contact());
        return  "contact.html";
    }

   /*
    @PostMapping(value={"/saveMsg"})
    public ModelAndView saveMessage(
            @RequestParam String name,
            @RequestParam String mobileNum,
            @RequestParam String email,
            @RequestParam String subject,
            @RequestParam String message
    ){
        log.info("name: " + name);
        log.info("mobileNum: " + mobileNum);
        log.info("email: " + email);
        log.info("subject: " + subject);
        log.info("message: " + message);
        return new ModelAndView("redirect:/contact");
    }*/

    @PostMapping(value={"/saveMsg"})
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.info("Contact form validation failed due to: " + errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
}
