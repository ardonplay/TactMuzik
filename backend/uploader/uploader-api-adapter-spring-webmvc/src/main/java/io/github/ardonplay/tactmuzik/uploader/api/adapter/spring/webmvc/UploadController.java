package io.github.ardonplay.tactmuzik.uploader.api.adapter.spring.webmvc;


import io.github.ardonplay.tactmuzik.uploader.api.UploadFileApi;
import io.github.ardonplay.tactmuzik.uploader.shared.dto.UploadDataOutDto;
import java.io.File;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/upload")
@RequiredArgsConstructor
public class UploadController {

  private final UploadFileApi uploadFileApi;

  public static boolean isFileAudio(MultipartFile file) {
    String contentType = file.getContentType();
    return contentType != null && (
        contentType.equals("audio/mpeg") ||
            contentType.equals("audio/flac") ||
            contentType.equals("audio/wav") ||
            contentType.equals("audio/ogg"));
  }

  @SneakyThrows
  @PostMapping()
  public ResponseEntity<UploadDataOutDto> upload(@RequestParam("file") MultipartFile file) {
    if (!isFileAudio(file)) {
      throw new HttpMediaTypeNotSupportedException("Media type is not supported");
    }
    File tempFile = File.createTempFile("temp", file.getOriginalFilename());
    file.transferTo(tempFile);
    return new ResponseEntity<>(uploadFileApi.uploadTrack(tempFile).orElseThrow(), HttpStatus.CREATED);
  }
}