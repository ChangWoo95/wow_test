package com.jodongari.wow.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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

    @Builder
    public Video(LocalDateTime createdDateTime, LocalDateTime updatedDatetime, Long id, String title, String fileName, String savedFileName, Boolean deleteFlag, Long likeCount, Long disLikeCount, Long viewCount, Long videoSize, String totalPlayTime, List<Comment> comments) {
        super(createdDateTime, updatedDatetime);
        this.id = id;
        this.title = title;
        this.fileName = fileName;
        this.savedFileName = savedFileName;
        this.deleteFlag = deleteFlag;
        this.likeCount = likeCount;
        this.disLikeCount = disLikeCount;
        this.viewCount = viewCount;
        this.videoSize = videoSize;
        this.totalPlayTime = totalPlayTime;
        this.comments = comments;
    }

}
