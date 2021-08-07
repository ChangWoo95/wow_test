package com.jodongari.wow.controller;

import com.jodongari.wow.dto.request.VideoRequest;
import com.jodongari.wow.service.FileStoreService;
import com.jodongari.wow.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class VideoApiController {

    private final VideoService videoService;

    @Autowired
    private FileStoreService fileService;

    @PostMapping(
            value = "/video/upload",
            consumes = {
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_OCTET_STREAM_VALUE}
    )
    public ResponseEntity<?> uploadVideo(@RequestPart("content") MultipartFile file) {
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

    @CrossOrigin("*")
    @GetMapping("/video/streaming/{file}")
    public void StreamVideo(HttpServletResponse response, @PathVariable String file) {
        try (FileInputStream fis = new FileInputStream("src/main/resources/video/" + file)) {
            IOUtils.copy(fis, response.getOutputStream());
        } catch (Exception e) {
            log.error("file Download Error - path : {}");
            log.error("exception Message : {}", e);
            throw new RuntimeException();
        }
    }
}
