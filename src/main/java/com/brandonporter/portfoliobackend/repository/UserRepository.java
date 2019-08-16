package com.brandonporter.portfoliobackend.repository;

import com.brandonporter.portfoliobackend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
