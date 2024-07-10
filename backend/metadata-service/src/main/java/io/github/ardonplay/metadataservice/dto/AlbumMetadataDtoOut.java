package io.github.ardonplay.metadataservice.dto;

import io.github.ardonplay.metadataservice.util.AlbumType;
import java.util.Date;
import java.util.List;

public record AlbumMetadataDtoOut(String id, String title, AlbumType type, List<ArtistMetadataDtoOut> artists, List<TrackMetadataDtoOut> tracks, Date releaseDate) {

}
