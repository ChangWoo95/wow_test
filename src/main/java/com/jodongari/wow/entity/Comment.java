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
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Video video;

    @Column(name = "COMMENT", nullable = false)
    private String comment;

    @Builder
    public Comment(Long id, User user, Video video, String comment) {
        this.id = id;
        this.user = user;
        this.video = video;
        this.comment = comment;
    }
}