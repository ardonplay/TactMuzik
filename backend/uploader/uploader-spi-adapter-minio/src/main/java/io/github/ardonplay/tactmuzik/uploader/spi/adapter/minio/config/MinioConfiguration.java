package io.github.ardonplay.tactmuzik.uploader.spi.adapter.minio.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MinioConfiguration {

  @Value("${minio.endpoint}")
  private String endpoint;

  @Value("${minio.accessKey}")
  private String accessKey;

  @Value("${minio.secretKey}")
  private String secretKey;

  @Value("${uploader.tracks.location}")
  public String trackBucket;

  @Value("${uploader.covers.location}")
  public String coverBucket;

  @Bean
  public MinioClient minioClient()
      throws InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, ServerException {
    MinioClient client = MinioClient.builder()
        .endpoint(endpoint)
        .credentials(accessKey, secretKey)
        .build();

    for (String bucket : List.of(trackBucket, coverBucket)) {
      boolean isBucketExist = client.bucketExists(
          BucketExistsArgs.builder().bucket(bucket).build());
      if (!isBucketExist) {
        client.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
      }
    }

    return client;
  }

}
