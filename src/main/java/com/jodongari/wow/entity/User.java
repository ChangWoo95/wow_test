package com.jodongari.wow.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class User extends BaseDateTime {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "USER_NICKNAME", nullable = false)
    private String nickName;

    @Column(name = "USER_GENDER", nullable = false, length = 1)
    private String gender;

    @Column(name = "USER_BIRTHDAY", nullable = false)
    private Date birthday;

    @Column(name = "USER_LAST_LOGGED_IN_IP", nullable = false)
    private String lastLoggedInIp;

    @Column(nullable = true)
    private String userProfileImageURL;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
//    private List<Video> uploadVideos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserVideoHistory> userVideoHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public User(Long id, String email, String nickName, String gender, Date birthday, String lastLoggedInIp, String userProfileImageURL, List<Video> uploadVideos, List<UserVideoHistory> userVideoHistories, List<Comment> comments) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.gender = gender;
        this.birthday = birthday;
        this.lastLoggedInIp = lastLoggedInIp;
        this.userProfileImageURL = userProfileImageURL;
//        this.uploadVideos = uploadVideos;
        this.userVideoHistories = userVideoHistories;
        this.comments = comments;
    }
}