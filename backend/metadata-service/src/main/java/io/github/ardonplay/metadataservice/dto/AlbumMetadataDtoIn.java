package io.github.ardonplay.metadataservice.dto;

import io.github.ardonplay.metadataservice.util.AlbumType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record AlbumMetadataDtoIn(String title, AlbumType type, List<UUID> artists, String genre, Date releaseDate, List<TrackMetadataDtoIn> tracks) {

}
