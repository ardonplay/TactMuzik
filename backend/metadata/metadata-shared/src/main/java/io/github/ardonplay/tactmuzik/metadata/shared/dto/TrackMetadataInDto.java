package io.github.ardonplay.tactmuzik.metadata.shared.dto;


import java.util.List;
import java.util.UUID;

public record TrackMetadataInDto(String title, List<UUID> artists, Long duration, String genre, String s3Path, String s3CoverPath, List<UUID> albums) {

}
