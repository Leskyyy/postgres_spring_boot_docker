// ******************************************************************
//
// Copyright 2023 PSI Software AG. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package com.odazie.simpleblog.service;

import com.odazie.simpleblog.model.Post;
import com.odazie.simpleblog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(Post post){
        getPostRepository().save(post);
    }

    public List<Post> getAllPosts(){
        return getPostRepository().findAll();
    }

    public void deletePost(Post post){
        getPostRepository().delete(post);
    }

    public PostRepository getPostRepository() {
        return postRepository;
    }
}
