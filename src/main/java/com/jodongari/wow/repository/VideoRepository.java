package com.jodongari.wow.repository;

import com.jodongari.wow.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long>, VideoRepositoryCustom {
}
