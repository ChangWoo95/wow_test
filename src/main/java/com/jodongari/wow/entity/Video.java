package com.jodongari.wow.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Video extends BaseDateTime {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO max length set
    @Column
    private String title;

    @Column
    private String fileName;

    @Column
    private String savedFileName;

    @Column
    private Boolean deleteFlag;

    @Column
    private Long likeCount;

    @Column
    private Long disLikeCount;

    @Column
    private Long viewCount;

    @Column
    private Long videoSize;

    @Column
    private String totalPlayTime;

    @OneToMany
    private List<Comment> comments = new ArrayList<>();

}
