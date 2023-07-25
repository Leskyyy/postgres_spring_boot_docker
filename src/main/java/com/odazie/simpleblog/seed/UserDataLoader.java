package com.odazie.simpleblog.seed;

import com.odazie.simpleblog.model.User;
import com.odazie.simpleblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Component
public class UserDataLoader implements CommandLineRunner
{

    @Autowired
    UserRepository userRepository;

    @Override
    public void run( String ... args ) throws Exception
    {
        loadUserData();
    }

    private void loadUserData()
    {
        User user1 = new User();
        user1.setEmail( "john.doe@gmail.com" );
        user1.setUsername( "johndoe" );
        user1.setPassword( "password123" );

        User user2 = new User();
        user2.setEmail( "emma.smith@yahoo.com" );
        user2.setUsername( "emmas" );
        user2.setPassword( "p@ssword!" );

        User user3 = new User();
        user3.setEmail( "williamj@example.com" );
        user3.setUsername( "willj" );
        user3.setPassword( "securePassword" );

        User user4 = new User();
        user4.setEmail( "laura_hernandez@hotmail.com" );
        user4.setUsername( "laurah" );
        user4.setPassword( "myP@$$w0rd" );

        User user5 = new User();
        user5.setEmail( "alex_wong@outlook.com" );
        user5.setUsername( "alexwong" );
        user5.setPassword( "StrongP@ssw0rd" );

        userRepository.saveAll( List.of( user1, user2, user3, user4, user5 ) );
    }
}
