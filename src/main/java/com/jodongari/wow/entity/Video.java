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
    public Video(Long id, String title, String fileName, String savedFileName, Boolean deleteFlag, Long likeCount, Long disLikeCount, Long viewCount, Long videoSize, String totalPlayTime, List<Comment> comments) {
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
