package io.github.ardonplay.metadataservice.dto;


import java.util.List;
import java.util.UUID;

public record TrackMetadataDtoIn(String title, List<UUID> artists, Long duration, List<String> genres, String s3Path, String s3CoverPath, List<UUID> albums) {

}
