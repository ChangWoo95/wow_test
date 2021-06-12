package com.jodongari.wow.controller;

import com.jodongari.wow.dto.request.VideoRequest;
import com.jodongari.wow.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class VideoApiController {

    private final VideoService videoService;

    @PostMapping("/video/upload")
    public ResponseEntity uploadVideo(@RequestBody VideoRequest videoRequest) {

        videoService.uploadVideo(videoRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
