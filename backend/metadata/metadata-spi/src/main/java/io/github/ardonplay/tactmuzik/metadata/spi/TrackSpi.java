package io.github.ardonplay.tactmuzik.metadata.spi;

import io.github.ardonplay.tactmuzik.metadata.shared.data.TrackData;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataOutDto;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface TrackSpi {

  TrackMetadataOutDto getTrackMetadata(UUID trackId);

  TrackMetadataOutDto addTrackMetadata(TrackMetadataInDto trackMetadataDtoIn);

  TrackMetadataOutDto updateTrackMetadata(TrackMetadataOutDto trackMetadata);

  void deleteTrackMetadata(UUID trackId);

  TrackData getTrack(UUID trackId);

  List<TrackData> getTracks(Collection<UUID> trackIds);
}
