package com.bridgelabz.Multi_Step.form.controller;

import com.bridgelabz.Multi_Step.form.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("userForm")
public class FormController {

    @ModelAttribute("userForm")
    public UserForm setUpForm() {
        return new UserForm();
    }

    @GetMapping("/step1")
    public String step1() {
        return "step1";
    }

    @PostMapping("/step1")
    public String saveStep1(@ModelAttribute("userForm") UserForm form,
                            @RequestParam String firstName,
                            @RequestParam String lastName) {
        form.setFirstName(firstName);
        form.setLastName(lastName);
        return "redirect:/step2";
    }

    @GetMapping("/step2")
    public String step2() {
        return "step2";
    }

    @PostMapping("/step2")
    public String saveStep2(@ModelAttribute("userForm") UserForm form,
                            @RequestParam String email,
                            @RequestParam String phone) {
        form.setEmail(email);
        form.setPhone(phone);
        return "redirect:/step3";
    }

    @GetMapping("/step3")
    public String step3() {
        return "step3";
    }

    @PostMapping("/step3")
    public String saveStep3(@ModelAttribute("userForm") UserForm form,
                            @RequestParam String city,
                            @RequestParam String country) {
        form.setCity(city);
        form.setCountry(country);
        return "redirect:/summary";
    }

    @GetMapping("/summary")
    public String summary() {
        return "summary";
    }
}
