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
@Table(name = "USER")
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

<<<<<<< HEAD
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
//    private List<Video> uploadVideos = new ArrayList<>();

=======
>>>>>>> 32390fd8282c222fe50a49a9f0fdb1f31c4fbf03
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserVideoHistory> userVideoHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public User(Long id, String email, String nickName, String gender, Date birthday, String lastLoggedInIp, String userProfileImageURL, List<UserVideoHistory> userVideoHistories, List<Comment> comments) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.gender = gender;
        this.birthday = birthday;
        this.lastLoggedInIp = lastLoggedInIp;
        this.userProfileImageURL = userProfileImageURL;
<<<<<<< HEAD
//        this.uploadVideos = uploadVideos;
=======
>>>>>>> 32390fd8282c222fe50a49a9f0fdb1f31c4fbf03
        this.userVideoHistories = userVideoHistories;
        this.comments = comments;
    }
}