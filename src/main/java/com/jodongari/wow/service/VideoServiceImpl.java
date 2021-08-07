package com.jodongari.wow.service;

import com.jodongari.wow.dto.request.VideoRequest;
import com.jodongari.wow.entity.Video;
import com.jodongari.wow.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private static final String FILE_PATH = "resources/video/";

    private final VideoRepository videoRepository;

    @Override
    public String getSavedFileName(Long videoId) {
        return videoRepository.searchSavedFileName(videoId);
    }

    @Override
    @Transactional
    public void uploadVideo(VideoRequest videoRequest) {

        Video video = saveVideo(videoRequest.getVideo());

        video.builder()
                .title(videoRequest.getTitle())
                .description(videoRequest.getDescription());

        videoRepository.save(video);
    }

    private void saveUserProfileImage(MultipartFile image) {

    }

    private Video saveVideo(MultipartFile videoFile) {

        Date date = new Date();
        String timeStamp = Long.toString(date.getTime());

        String videoFileName = videoFile.getOriginalFilename();
        StringBuffer videoSavedFileName = new StringBuffer(videoFileName.concat("_" + timeStamp).concat(FilenameUtils.getExtension(videoFile.getOriginalFilename())));
        String dirPath = getDirPath();

        File fileObj = new File(FILE_PATH + dirPath + videoSavedFileName.toString());

        try {
            videoFile.transferTo(fileObj);
        } catch (Exception e) {
            log.error("file Save Error - path : {}", fileObj);
            log.error("exception Message : {}", e);
            throw new RuntimeException();
        }

        return Video.builder()
                .fileName(videoFileName)
                .savedFileName(videoSavedFileName.toString())
                .size(videoFile.getSize())
                .build();
    }

    private String getDirPath() {
        String dirPath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + "/";
        File file = new File(FILE_PATH + dirPath);

        if (!file.isDirectory()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                log.error("make comment date folder error {}", e);
            }
        }

        return dirPath;
    }

}
