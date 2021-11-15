package com.dreamHome.dreamHome.controllers;


import com.dreamHome.dreamHome.models.Listing;
import com.dreamHome.dreamHome.models.Location;
import com.dreamHome.dreamHome.models.User;
import com.dreamHome.dreamHome.repositories.LocationRepository;
import com.dreamHome.dreamHome.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepository userDoa;
    private LocationRepository locationDoa;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDoa,LocationRepository locationDoa, PasswordEncoder passwordEncoder) {
        this.userDoa = userDoa;
        this.locationDoa = locationDoa;
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

    @GetMapping("/editProfile/{id}")
    public String editPost(Model model, @PathVariable Long id) {

        User user = userDoa.getById(id);
        Location location = locationDoa.getById(id);


        model.addAttribute("user", user);
        model.addAttribute("location", location);

        return "editProfile";
    }

    @PostMapping("/editProfile/{id}")
    public String editListing(@PathVariable Long id,
                              @ModelAttribute User updateUser,
                              @ModelAttribute Location updateLocation) {


        updateUser.setId(id);
        updateLocation.setId(id);

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        updateUser.setOwner(userDoa.getById(currentUser.getId()));
//        updateUser.setId(userDoa.getById(currentUser.getId()));

        userDoa.save(updateUser); // this will update the listing repository
        locationDoa.save(updateLocation); // this will update the location repo

        return "redirect:/user/profile";
    }

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
