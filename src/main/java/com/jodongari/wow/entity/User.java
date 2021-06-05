package com.jodongari.wow.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class User extends BaseDateTime {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickName;

    @Column
    private String gender;

    @Column
    private String birthday;

    @Column
    private String lasLoggedInIp;

    @Column
    private String thumbNailURL;

    @OneToMany
    private List<Video> uploadVideos = new ArrayList<>();

    @OneToMany
    private List<UserVideoHistory> userVideoHistories = new ArrayList<>();

    @OneToMany
    private List<Comment> comments = new ArrayList<>();

}