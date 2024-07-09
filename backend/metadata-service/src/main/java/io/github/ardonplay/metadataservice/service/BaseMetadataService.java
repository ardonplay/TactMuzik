package io.github.ardonplay.metadataservice.service;

import io.github.ardonplay.metadataservice.entity.MusicTrackEntity;
import io.github.ardonplay.metadataservice.repository.TrackRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseMetadataService {

  private final TrackRepository trackRepository;

  public MusicTrackEntity getMusicTrack(UUID uuid) {
    return trackRepository.findById(uuid).get();
  }
}
