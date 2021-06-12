package com.jodongari.wow.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Video extends BaseDateTime {

    @Id
    @Column(name = "VIDEO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VIDEO_TITLE", nullable = false, length = 100)
    private String title;

    @Column(name = "VIDEO_FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "VIDEO_SAVED_FILE_NAME", nullable = false)
    private String savedFileName;

    @Column(name = "VIDEO_DELETE_FLAG", nullable = false)
    private Boolean deleteFlag = false;

    @Column(name = "VIDEO_LIKE_COUNT")
    private Long likeCount;

    @Column(name = "VIDEO_DISLIKE_COUNT")
    private Long disLikeCount;

    @Column(name = "VIDEO_VIEW_COUNT")
    private Long viewCount;

    @Column(name = "VIDEO_SIZE")
    private Long size;

    @Column(name = "VIDEO_RUNNING_TIME")
    private String runningTime;

    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Video(Long id, String title, String fileName, String savedFileName, Boolean deleteFlag, Long likeCount, Long disLikeCount, Long viewCount, Long size, String runningTime, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.fileName = fileName;
        this.savedFileName = savedFileName;
        this.deleteFlag = deleteFlag;
        this.likeCount = likeCount;
        this.disLikeCount = disLikeCount;
        this.viewCount = viewCount;
        this.size = size;
        this.runningTime = runningTime;
        this.comments = comments;
    }

}
