package com.socialmedia.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String getDashboard(Model model) {
        model.addAttribute("message", "Bienvenue sur le dashboard admin !");
        return "admin/dashboard";
    }
}
