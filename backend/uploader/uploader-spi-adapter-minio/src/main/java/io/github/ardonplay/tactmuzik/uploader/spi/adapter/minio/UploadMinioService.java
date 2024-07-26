package io.github.ardonplay.tactmuzik.uploader.spi.adapter.minio;

import io.github.ardonplay.tactmuzik.uploader.spi.FileUploader;
import io.github.ardonplay.tactmuzik.uploader.spi.exceptions.FileUploadException;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import java.io.InputStream;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UploadMinioService implements FileUploader {

  private final MinioClient minioClient;

  @Override
  public void uploadFile(String name, String location, String contentType, InputStream fileStream)
      throws FileUploadException {
    try {
      minioClient.putObject(
          PutObjectArgs.builder().object(name).bucket(location).contentType(contentType)
              .stream(fileStream, fileStream.available(), -1).build());
    } catch (Exception e) {
      throw new FileUploadException(e);
    }
  }
}
