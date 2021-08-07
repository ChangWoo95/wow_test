package com.jodongari.wow.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class VideoRequest {

    private String title;
    private String description;
    private MultipartFile thumbnailImage;
    private MultipartFile video;
}
