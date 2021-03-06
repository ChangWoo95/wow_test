package com.jodongari.wow.service;

import lombok.extern.slf4j.Slf4j;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFmpegUtils;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class FileStoreService {

    FFmpeg ffmpeg = null;
    FFprobe ffprobe = null;

    public FileStoreService(
            @Value("${server.compression.ffmpeg}") String ffmpegPath,
            @Value("${server.compression.ffprobe}") String ffprobePath) throws IOException {

        // Mac ver
//        ffmpeg = new FFmpeg();
//        if (!StringUtils.isEmpty(ffmpegPath))
//            ffmpeg = new FFmpeg(ffmpegPath);
//        ffprobe = new FFprobe();

//        if (!StringUtils.isEmpty(ffprobePath))
//            ffprobe = new FFprobe(ffprobePath);

        // Window ver
        ffmpeg = new FFmpeg("src/main/resources/ffmpeg/bin/ffmpeg");
        ffprobe = new FFprobe("src/main/resources/ffmpeg/bin/ffprobe");

    }

    public enum TypeOfMedia {
        Pictures, Videos
    }

    public static String getHomeDir() {
        return System.getProperty("user.home");
    }

    public String createFile(MultipartFile file, TypeOfMedia type) throws IOException {
        String dirPath = getHomeDir() + File.separator +
                type.toString() + File.separator +
                "original" + File.separator +
                LocalDate.now();

        String fileName = String.format(
                "%s.%s",
                UUID.randomUUID(),
                FilenameUtils.getExtension(file.getOriginalFilename())
        );

        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String location = dirPath + File.separator + fileName;
        Path path = Paths.get(location);
        Files.write(path, file.getBytes());
        return location;
    }

    public void convertVideo(String fileName, String format) throws IOException {
        String dirPath = getHomeDir() + File.separator +
                TypeOfMedia.Videos + File.separator +
                "compressed" + File.separator +
                LocalDate.now();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        FFmpegProbeResult input = ffprobe.probe(fileName);

        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(input).overrideOutputFiles(true)

                .addOutput(new StringBuilder(dirPath)
                        .append(File.separator).append(UUID.randomUUID().toString()).append(".").append(format).toString())
                .setFormat(format)
                .disableSubtitle()

//                config audio
                .setAudioChannels(1)
                .setAudioCodec("aac")
                .setAudioSampleRate(48_000)
                .setAudioBitRate(32_768)

//                config video
                .setVideoCodec("libx264")
                .setVideoFrameRate(24, 1)
                .setVideoResolution(640, 480)

                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createJob(builder, new ProgressListener() {

            final double duration_ns = input.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

            @Override
            public void progress(Progress progress) {
                double percentage = progress.out_time_ns / duration_ns;
                log.info("filename: {} -> {} status: {} time: {} ms",
                        input.getFormat().filename,
                        String.format("[%.0f%%]", (percentage * 100)),
                        progress.status,
                        FFmpegUtils.toTimecode(progress.out_time_ns, TimeUnit.NANOSECONDS)
                );
            }
        }).run();
    }

    public void getThumbnailByVideo(String filePath) {
    }

}