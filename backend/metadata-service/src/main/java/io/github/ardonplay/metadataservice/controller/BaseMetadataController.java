package io.github.ardonplay.metadataservice.controller;

import io.github.ardonplay.metadataservice.entity.MusicTrackEntity;
import io.github.ardonplay.metadataservice.service.BaseMetadataService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/metadata")
@RequiredArgsConstructor
public class BaseMetadataController {

  private final BaseMetadataService baseMetadataService;

  @GetMapping("/{id}")
  public MusicTrackEntity get(@PathVariable("id") UUID id) {
    return baseMetadataService.getMusicTrack(id);
  }

}
