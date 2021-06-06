package com.jodongari.wow.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
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
    private String lastLoggedInIp;

    @Column
    private String thumbNailURL;

    @OneToMany
    private List<Video> uploadVideos = new ArrayList<>();

    @OneToMany
    private List<UserVideoHistory> userVideoHistories = new ArrayList<>();

    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public User(Long id, String email, String password, String nickName, String gender, String birthday, String lastLoggedInIp, String thumbNailURL, List<Video> uploadVideos, List<UserVideoHistory> userVideoHistories, List<Comment> comments) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.gender = gender;
        this.birthday = birthday;
        this.lastLoggedInIp = lastLoggedInIp;
        this.thumbNailURL = thumbNailURL;
        this.uploadVideos = uploadVideos;
        this.userVideoHistories = userVideoHistories;
        this.comments = comments;
    }
}