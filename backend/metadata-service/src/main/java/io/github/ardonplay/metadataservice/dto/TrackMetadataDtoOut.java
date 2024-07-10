package io.github.ardonplay.metadataservice.dto;

import java.util.List;

public record TrackMetadataDtoOut(String id, String title, Long duration, List<ArtistMetadataDtoOut> artists, String s3Path, String s3CoverPath) {

}
