package com.dreamHome.dreamHome.controllers;

import com.dreamHome.dreamHome.models.Listing;
import com.dreamHome.dreamHome.models.User;
import com.dreamHome.dreamHome.repositories.ListingRepository;
import com.dreamHome.dreamHome.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ListingController {

    private final ListingRepository searchDoa;
    private final UserRepository userDao;

    public ListingController(ListingRepository searchDoa, UserRepository userDao) {
        this.searchDoa = searchDoa;
        this.userDao = userDao;
    }



    @GetMapping("/search/{id}")
    public String searchView(Model model, @PathVariable Long id) {
        Optional<Listing> searchedListings = searchDoa.findById(id);

        model.addAttribute("searchList", searchedListings);

        return "search";
    }


    @PostMapping("/search/{id}")
    public String search(@PathVariable String id) {
        return "search";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("listing", new Listing());
        return "createListing";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Listing listing){

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        listing.setOwner(userDao.getById(currentUser.getId())); // grabbing whatever user is currently logged in(current user session)
        searchDoa.save(listing);
        return "redirect:/profileUser";
    }
    @GetMapping("/edit/{id}")
    public String editPost(Model model, @PathVariable Long id) {

        Listing singleListing = searchDoa.getById(id);

        model.addAttribute("post", singleListing);

        return "profileUser";
    }

    @PostMapping("/edit/{id}")
    public String editListing(@PathVariable Long id, @ModelAttribute Listing updateListing) {


        updateListing.setId(id);

        updateListing.setOwner(userDao.getById(1L));

        searchDoa.save(updateListing);

        return "redirect:/profileUser";
    }


    @PostMapping("/delete/{id}")
    public String deleteListing(Model model, @PathVariable Long id) {

        Listing deleteListing = searchDoa.getById(id);
        searchDoa.delete(deleteListing);


        return "redirect:/profileUser";
    }


}
