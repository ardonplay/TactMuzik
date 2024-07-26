package io.github.ardonplay.tactmuzik.metadata.api;

import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataOutDto;
import java.util.Optional;
import java.util.UUID;

public interface TrackOperationsApi {

  Optional<TrackMetadataOutDto> getTrackMetadata(UUID uuid);

  Optional<TrackMetadataOutDto> updateTrackMetadata(TrackMetadataOutDto updateTrackMetadataDto);

  void deleteTrack(UUID uuid);

  Optional<TrackMetadataOutDto> createTrack(TrackMetadataInDto newTrack);

}
