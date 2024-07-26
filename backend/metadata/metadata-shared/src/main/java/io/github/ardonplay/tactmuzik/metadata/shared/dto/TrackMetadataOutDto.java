package io.github.ardonplay.tactmuzik.metadata.shared.dto;

import java.util.List;
import java.util.UUID;

public record TrackMetadataOutDto(UUID id, String title, Long duration, List<ArtistMetadataOutDto> artists, String s3Path, String s3CoverPath) {

}
