package io.github.ardonplay.tactmuzik.metadata.shared.dto;

import io.github.ardonplay.tactmuzik.metadata.shared.enums.AlbumType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record AlbumMetadataInDto(String title, AlbumType type, List<UUID> artists, String genre, Date releaseDate, List<TrackMetadataInDto> tracks) {

}
