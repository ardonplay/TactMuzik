package io.github.ardonplay.tactmuzik.metadata.core;

import io.github.ardonplay.tactmuzik.metadata.api.TrackOperationsApi;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataOutDto;
import io.github.ardonplay.tactmuzik.metadata.spi.TrackSpi;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackOperationsUseCase implements TrackOperationsApi {

  private final TrackSpi trackSpi;

  @Override
  public Optional<TrackMetadataOutDto> getTrackMetadata(UUID uuid) {
    return Optional.of(trackSpi.getTrackMetadata(uuid));
  }

  @Override
  public Optional<TrackMetadataOutDto> updateTrackMetadata(
      TrackMetadataOutDto updateTrackMetadataDto) {
    return Optional.of(trackSpi.updateTrackMetadata(updateTrackMetadataDto));
  }

  @Override
  public void deleteTrack(UUID uuid) {
    trackSpi.deleteTrackMetadata(uuid);
  }

  @Override
  public Optional<TrackMetadataOutDto> createTrack(TrackMetadataInDto newTrack) {
    return Optional.of(trackSpi.addTrackMetadata(newTrack));
  }
}
