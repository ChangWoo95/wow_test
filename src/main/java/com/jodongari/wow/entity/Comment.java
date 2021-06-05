package com.jodongari.wow.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
public class Comment extends BaseDateTime {

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

    @Builder
    public Comment(LocalDateTime createdDateTime, LocalDateTime updatedDatetime, Long id, User user, Video video, String comment) {
        super(createdDateTime, updatedDatetime);
        this.id = id;
        this.user = user;
        this.video = video;
        this.comment = comment;
    }
}