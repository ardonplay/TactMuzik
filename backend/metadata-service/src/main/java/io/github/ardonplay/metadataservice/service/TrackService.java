package io.github.ardonplay.metadataservice.service;

import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.TrackEntity;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface TrackService {

  TrackMetadataDtoOut getTrackMetadata(UUID trackId);

  TrackMetadataDtoOut addTrackMetadata(TrackMetadataDtoIn trackMetadataDtoIn);

  void deleteTrackMetadata(UUID trackId);

  TrackEntity getTrack(UUID trackId);

  List<TrackEntity> getTracks(Collection<UUID> trackIds);
}
