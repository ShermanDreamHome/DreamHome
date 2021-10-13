package com.dreamHome.dreamHome.repositories;


import com.dreamHome.dreamHome.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Listing, Long> {
}
