package io.github.ardonplay.tactmuzik.uploadservice.service;


import io.github.ardonplay.tactmuzik.uploadservice.config.MinioConfiguration;
import io.github.ardonplay.tactmuzik.uploadservice.dto.UploadDataDtoOut;
import io.github.ardonplay.tactmuzik.uploadservice.exception.file.UnsupportedFileTypeException;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.datatype.Artwork;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadService {

    private final MinioClient minioClient;

    private final MinioConfiguration minioConfiguration;


    public UploadDataDtoOut upload(MultipartFile file) throws IOException, CannotReadException, TagException, InvalidAudioFrameException, ReadOnlyFileException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, UnsupportedFileTypeException {
        if(!UtliMethodsService.isFileAudio(file)) throw new UnsupportedFileTypeException(file.getOriginalFilename());

        log.info("File: {}", file.getOriginalFilename());
        log.info("Size: {}", file.getSize());
        log.info("Mimetype: {}", file.getContentType());

        UploadDataDtoOut uploadDataDtoOut = new UploadDataDtoOut();
        File tempFile = File.createTempFile("temp", file.getOriginalFilename());
        file.transferTo(tempFile);
        AudioFile audioFile = AudioFileIO.read(tempFile);

        Tag tag = audioFile.getTag();

        if (!tag.getArtworkList().isEmpty()) {
            Artwork cover = tag.getFirstArtwork();
            String coverId = UtliMethodsService.calculateMD5(cover.getBinaryData());
            InputStream coverInputStream = new ByteArrayInputStream(cover.getBinaryData());
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(minioConfiguration.coverBucket)
                    .object(String.valueOf(coverId))
                    .contentType(cover.getMimeType())
                    .stream(coverInputStream, coverInputStream.available(), -1)
                    .build());
            coverInputStream.close();
            uploadDataDtoOut.setCoverId(coverId);
        }

        String trackId = UtliMethodsService.calculateMD5(tempFile);
        InputStream trackInputStream = new FileInputStream(tempFile);
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(minioConfiguration.trackBucket)
                .object(String.valueOf(trackId))
                .contentType(file.getContentType())
                .stream(trackInputStream, trackInputStream.available(), -1)
                .build());
        trackInputStream.close();
        uploadDataDtoOut.setTrackId(trackId);

        return uploadDataDtoOut;
    }

}
