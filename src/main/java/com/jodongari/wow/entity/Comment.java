package com.jodongari.wow.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
public class Comment extends BaseDateTime implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Video video;

    private String comment;

}