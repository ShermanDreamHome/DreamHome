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
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserRepository userDao;
    private LocationRepository locationDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao,LocationRepository locationDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.locationDao = locationDao;
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
       model.addAttribute("user", userDao.getById(currentUserSession.getId())); //gets user by session
        return "profileUser";
    }

    @GetMapping("/editProfile/{id}")
    public String editProfile(Model model, @PathVariable Long id) {

        User user = userDao.getById(id);
        Location location = locationDao.getById(id);


        model.addAttribute("user", user);
        model.addAttribute("location", location);

        return "editProfile";
    }

    @PostMapping("/editProfile/{id}")
    public String editProfile(@PathVariable Long id,
                              @ModelAttribute User updateUser,
                              @ModelAttribute Location updateLocation,
                              @RequestParam(name = "product_image_url") String photoUrl) {


//        updateUser.setId(id);
        updateLocation.setId(id);

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        updateUser.setId(currentUser.getId());

        userDao.save(updateUser); // this will update the listing repository
        locationDao.save(updateLocation); // this will update the location repo


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
        userDao.save(user);
        return "redirect:/login";

    }


    //
}
