package com.dreamHome.dreamHome.repositories;


import com.dreamHome.dreamHome.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {

    Listing getListingByDescription(String description);

    Listing getListingById(String id);

}
