package com.dreamHome.dreamHome.controllers;


import com.dreamHome.dreamHome.models.User;
import com.dreamHome.dreamHome.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepository userDoa;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDoa, PasswordEncoder passwordEncoder) {
        this.userDoa = userDoa;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/hero")
    public String home(){
        return "hero";
    }

    @PostMapping("/hero")
    public String goHome () {
        return "hero";
    }


    @GetMapping("/user/profile")
    public String viewUserProfile(Model model) {
        User currentUserSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(currentUserSession);
       model.addAttribute("user", userDoa.getById(currentUserSession.getId())); //gets user by session
        return "profileUser";
    }

//    @PostMapping("/user/profile")
//    public String userProfile(){
//        return "profileUser";
//    }

    @GetMapping("/admin/profile")
    public String viewAdminProfile() {
        return "profileAdmin";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/user/favorites")
    public String showFavorites(Model model) {
        return "favoritesUser";
    }
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setIsAdmin(false);
        userDoa.save(user);
        return "redirect:/login";

    }


    //
}
