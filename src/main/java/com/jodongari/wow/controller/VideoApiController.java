package com.jodongari.wow.controller;

import com.jodongari.wow.dto.request.VideoRequest;
import com.jodongari.wow.service.FileStoreService;
import com.jodongari.wow.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class VideoApiController {

    private final VideoService videoService;
    private final String FILE_LOCATION = "resources/video/";

    @Autowired
    private FileStoreService fileService;

    @PostMapping(
            value = "/upload/video",
            consumes = {
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_OCTET_STREAM_VALUE}
    )
    public ResponseEntity<?> createVideo(@RequestPart("content") MultipartFile file) {
        try {
            String fileName = fileService.createFile(file, FileStoreService.TypeOfMedia.Videos);
            fileService.convertVideo(fileName, "mp4");
            System.out.println("Path : " + fileName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/video/upload")
    public ResponseEntity uploadVideo(@RequestBody VideoRequest videoRequest) {

        videoService.uploadVideo(videoRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //동영상 전체 다운로드
    @GetMapping("/video/download/{videoId}/full")
    public ResponseEntity<UrlResource> getFullVideo(@PathVariable Long videoId) throws MalformedURLException {

        log.info("get VideoFull");
        final String FILE_NAME = videoService.getSavedFileName(videoId);
        UrlResource videoResource = new UrlResource("classpath:" + FILE_LOCATION + "/" + FILE_NAME);

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(videoResource).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(videoResource);
    }

    //동영상 파일 부분 다운로드
    @GetMapping("/video/download/{videoId}")
    public ResponseEntity<ResourceRegion> getVideoPart(@PathVariable Long videoId,
                                                   @RequestHeader HttpHeaders headers) throws IOException {

        log.info("get VideoPart");
        final String FILE_NAME = videoService.getSavedFileName(videoId);
        UrlResource videoResource = new UrlResource("classpath:" + FILE_LOCATION + "/" + FILE_NAME);

        ResourceRegion filePart = getFilePart(videoResource, headers);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(videoResource).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(filePart);
    }



    // 헤더속 범위만큼의 파일 불러오기
    private ResourceRegion getFilePart(UrlResource videoResource, HttpHeaders headers) throws IOException {

        final long chunkSize = 1000000L;
        long contentLength = videoResource.contentLength();

        HttpRange httpRange = headers.getRange().stream().findFirst().get();

        if(httpRange != null) {
            long start = httpRange.getRangeStart(contentLength);
            long end = httpRange.getRangeEnd(contentLength);
            long rangeLength = Long.min(chunkSize, end - start + 1);
            return new ResourceRegion(videoResource, start, rangeLength);
        } else {
            long rangeLength = Long.min(chunkSize, contentLength);
            return new ResourceRegion(videoResource, 0, rangeLength);
        }
    }
}
