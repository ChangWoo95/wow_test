package com.jodongari.wow.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
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
    public Comment(Long id, User user, Video video, String comment) {
        this.id = id;
        this.user = user;
        this.video = video;
        this.comment = comment;
    }
}