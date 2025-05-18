package com.example.laptopshop.controller;

import com.example.laptopshop.dto.LoginRequest;
import com.example.laptopshop.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.laptopshop.service.UserService;
import com.example.laptopshop.entity.User;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private UserService userService;

    @GetMapping("/custom-login")
    public String Login(Model model) {
        model.addAttribute("loginRequest" , new LoginRequest());
        return "login/login";
    }
    @GetMapping("/dashboard")
    public String Dashboard(Model model) {
        model.addAttribute("activeMenu", "user");
        return "dashboard/dashboard";
    }
    @GetMapping("/register")
    public String Register(Model model) {
        model.addAttribute("registerRequest" , new RegisterRequest());
        return "login/register";
    }
    @GetMapping("/user_list")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("activeMenu", "user");
        return "dashboard/list_user";
    }
    @GetMapping("/home")
    public String Home(Model model) {
        return "end_user/home";
    }
    @GetMapping("/detailproduct")
    public String Detail_product(Model model) {
        return "end_user/detailproduct";
    }
    @GetMapping("/order")
    public String Order(Model model) {
        return "end_user/order";
    }
}
