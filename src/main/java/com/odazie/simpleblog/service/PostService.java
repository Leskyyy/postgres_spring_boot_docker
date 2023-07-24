// ******************************************************************
//
// Copyright 2023 PSI Software AG. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package com.odazie.simpleblog.service;

import com.odazie.simpleblog.model.Post;
import com.odazie.simpleblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService
{

    @Autowired
    private PostRepository postRepository;

    public void savePost( Post post )
    {
        postRepository.save( post );
    }

    public List< Post > getAllPosts()
    {
        return postRepository.findAll();
    }

}
