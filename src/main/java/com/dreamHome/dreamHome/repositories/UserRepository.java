package com.dreamHome.dreamHome.repositories;

import com.dreamHome.dreamHome.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUsersById (String id);

}
