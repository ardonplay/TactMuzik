package io.github.ardonplay.metadataservice.dto;


import java.util.List;

public record TrackMetadataDtoIn(String title, List<String> artists, Long duration, String genre, String s3Path, String s3CoverPath, List<String> albums) {

}
