package com.dreamHome.dreamHome.controllers;

import com.dreamHome.dreamHome.models.Listing;
import com.dreamHome.dreamHome.models.Location;
import com.dreamHome.dreamHome.models.Photo;
import com.dreamHome.dreamHome.models.User;
import com.dreamHome.dreamHome.repositories.ListingRepository;
import com.dreamHome.dreamHome.repositories.LocationRepository;
import com.dreamHome.dreamHome.repositories.PhotoRepository;
import com.dreamHome.dreamHome.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ListingController {

    private final ListingRepository searchDoa;
    private final UserRepository userDao;
    private final LocationRepository locationDoa;
    private final PhotoRepository photoDao;

    public ListingController(ListingRepository searchDoa, UserRepository userDao, LocationRepository locationDoa, PhotoRepository photoDao) {
        this.searchDoa = searchDoa;
        this.userDao = userDao;
        this.locationDoa = locationDoa;
        this.photoDao = photoDao;
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

    @GetMapping("/createListing")
    public String createView(Model model) {
        User currentUserSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("listing", userDao.getById(currentUserSession.getId()));
        model.addAttribute("listing", new Listing());
        //reference listing from owner?
       model.addAttribute("location", new Location());
        return "createListing";
    }

    @PostMapping("/createListing")
    public String create(@ModelAttribute Listing listing,
                         @ModelAttribute Location location){

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        locationDoa.save(location);
        listing.setLocation(location);

        listing.setOwner(userDao.getById(currentUser.getId())); // grabbing whatever user is currently logged in(current user session)
        searchDoa.save(listing);


        return "redirect:/user/profile";
    }
    @GetMapping("/edit/{id}")
    public String editListing(Model model, @PathVariable Long id) {

        Listing singleListing = searchDoa.getById(id);
        Location location = locationDoa.getById(id);


        model.addAttribute("listing", singleListing);
        model.addAttribute("location", location);

        return "editListing";
    }

    @PostMapping("/edit/{id}")
    public String editListing(@PathVariable Long id,
                              @ModelAttribute Listing updateListing,
                              @ModelAttribute Location updateLocation,
                              @RequestParam(name = "product_image_url") String photoUrl) {


        updateListing.setId(id);
        updateLocation.setId(id);

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        updateListing.setOwner(userDao.getById(currentUser.getId()));

        updateListing = searchDoa.save(updateListing); // this will update the listing repository
        locationDoa.save(updateLocation); // this will update the location repo
        Photo photoToSave = new Photo();
        photoToSave.setListing(updateListing);
        photoToSave.setLocationUrl(photoUrl);
        photoDao.save(photoToSave); // saves photo's to repo





        return "redirect:/user/profile";
    }


    @PostMapping("/delete/{id}")
    public String deleteListing(Model model, @PathVariable Long id) {

        Listing deleteListing = searchDoa.getById(id);
        searchDoa.delete(deleteListing);


        return "redirect:/user/profile";
    }


}
