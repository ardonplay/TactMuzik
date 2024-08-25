package io.github.ardonplay.metadataservice.service;

import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoOut;
import io.github.ardonplay.metadataservice.exception.TrackNotFoundException;
import java.util.UUID;

public interface TrackService {

  TrackMetadataDtoOut getTrackMetadata(UUID trackId) throws TrackNotFoundException;

  TrackMetadataDtoOut addTrackMetadata(TrackMetadataDtoIn trackMetadataDtoIn);

  TrackMetadataDtoOut updateTrackMetadata(TrackMetadataDtoOut trackMetadataDtoOut);

  void deleteTrackMetadata(UUID trackId);


}
