// ******************************************************************
//
// Copyright 2023 PSI Software AG. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//
// ******************************************************************

package com.odazie.simpleblog.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "post" )
@Getter
@Setter
public class Post
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long postId;

    @NotNull
    @Column( name = "post_title", nullable = false )
    private String title;

    @Column( name = "post", columnDefinition = "TEXT" )
    private String post;
}
