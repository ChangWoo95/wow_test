package com.jodongari.wow.repository;

import com.jodongari.wow.entity.QVideo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class VideoRepositoryImpl implements VideoRepositoryCustom {
    static QVideo video;
    private final JPAQueryFactory queryFactory;

    // videoSavedFileName 찾기
    @Override
    public String searchSavedFileName(Long videoId) {
        return queryFactory
                .select(video.savedFileName)
                .from(video)
                .where(video.id.eq(videoId))
                .fetchOne();
    }
}
