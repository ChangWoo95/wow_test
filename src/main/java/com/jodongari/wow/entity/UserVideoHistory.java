package com.jodongari.wow.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class UserVideoHistory extends BaseDateTime {

    @Id
    @Column(name = "USER_VIDEO_HISTORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Video video;

    @Column(name = "IS_LIKE")
    private Boolean isLike;

    @Column(name = "IS_DISLIKE")
    private Boolean isDislike;

    @Builder
    public UserVideoHistory(Long id, User user, Video video, Boolean isLike, Boolean isDislike) {
        this.id = id;
        this.user = user;
        this.video = video;
        this.isLike = isLike;
        this.isDislike = isDislike;
    }
}
