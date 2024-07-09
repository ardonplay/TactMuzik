package io.github.ardonplay.tactmuzik.streamingservice.service;

import io.github.ardonplay.tactmuzik.streamingservice.config.MinioConfiguration;
import io.github.ardonplay.tactmuzik.streamingservice.exception.ObjectNotFoundException;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrackCoverService {

  private final MinioClient minioClient;
  private final MinioConfiguration minioConfiguration;

  public GetObjectResponse getTrackCoverById(String id) {
    try {
      return minioClient.getObject(
          GetObjectArgs.builder()
              .bucket(minioConfiguration.coverBucketName)
              .object(id)
              .build());
    } catch (Exception ex) {
      String msg = String.format("Cover '%s' not found", id);
      log.warn(msg);
      throw new ObjectNotFoundException(msg);
    }
  }
}
