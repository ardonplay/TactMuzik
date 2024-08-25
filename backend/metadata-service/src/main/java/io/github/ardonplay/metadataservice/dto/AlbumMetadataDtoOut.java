package io.github.ardonplay.metadataservice.dto;

import io.github.ardonplay.metadataservice.util.AlbumType;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

public record AlbumMetadataDtoOut(UUID id, String title, AlbumType type, List<String> genres, List<ArtistMetadataDtoOut> artists, List<TrackMetadataDtoOut> tracks, Date releaseDate) {

}
