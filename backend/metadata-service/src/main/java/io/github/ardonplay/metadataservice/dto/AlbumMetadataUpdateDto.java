package io.github.ardonplay.metadataservice.dto;

import io.github.ardonplay.metadataservice.util.AlbumType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record AlbumMetadataUpdateDto(UUID id, String title, AlbumType type, List<String> genres, List<UUID> artists, Date releaseDate) {

}
