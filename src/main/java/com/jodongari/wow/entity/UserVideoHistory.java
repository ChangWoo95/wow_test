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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Video video;

    @Column
    private Boolean isLike;

    @Column
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
