package io.github.ardonplay.tactmuzik.uploader.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationConfiguration {

  @Value("${uploader.tracks.location}")
  public String trackBucket;

  @Value("${uploader.covers.location}")
  public String coverBucket;

}
