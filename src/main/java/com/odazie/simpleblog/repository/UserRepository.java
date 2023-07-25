package com.odazie.simpleblog.repository;

import com.odazie.simpleblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long >
{

    User findByUserId( Long userId );

    @Override
    List< User > findAll();

}
