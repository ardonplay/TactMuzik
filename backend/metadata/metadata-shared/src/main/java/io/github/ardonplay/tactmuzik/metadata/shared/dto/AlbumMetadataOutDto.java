package io.github.ardonplay.tactmuzik.metadata.shared.dto;


import io.github.ardonplay.tactmuzik.metadata.shared.enums.AlbumType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record AlbumMetadataOutDto(UUID id, String title, AlbumType type, List<ArtistMetadataOutDto> artists, List<TrackMetadataOutDto> tracks, Date releaseDate) {

}
