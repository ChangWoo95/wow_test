package com.jodongari.wow.entity;


import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
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
    public UserVideoHistory(LocalDateTime createdDateTime, LocalDateTime updatedDatetime, Long id, User user, Video video, Boolean isLike, Boolean isDislike) {
        super(createdDateTime, updatedDatetime);
        this.id = id;
        this.user = user;
        this.video = video;
        this.isLike = isLike;
        this.isDislike = isDislike;
    }
}
