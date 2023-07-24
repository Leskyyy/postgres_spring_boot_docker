// ******************************************************************
//
// Copyright 2023 PSI Software AG. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package com.odazie.simpleblog.controller;

import com.odazie.simpleblog.service.PostService;
import com.odazie.simpleblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController
{

    @Autowired
    private PostService postService;

    @PostMapping( "/posts" )
    public ResponseEntity< Post > createPost( @RequestBody Post post )
    {
        postService.savePost( post );
        System.out.println("Essa");
        return new ResponseEntity<>( post, HttpStatus.CREATED );
    }

    @GetMapping( "/posts" )
    public ResponseEntity< List< Post > > getAllPosts()
    {
        return new ResponseEntity<>( postService.getAllPosts(), HttpStatus.OK );
    }
}
