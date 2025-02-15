package com.odazie.simpleblog.repository;

import com.odazie.simpleblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long >
{
    Optional<User> findByEmail(String email);

    User findByUserId( Long userId );

    @Override
    List< User > findAll();

}
