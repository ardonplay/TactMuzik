package io.github.ardonplay.tactmuzik.uploader.spi;

import io.github.ardonplay.tactmuzik.uploader.spi.exceptions.FileUploadException;
import java.io.InputStream;

@FunctionalInterface
public interface FileUploader {

  void uploadFile(String name, String location, String contentType, InputStream fileStream)
      throws FileUploadException;
}
