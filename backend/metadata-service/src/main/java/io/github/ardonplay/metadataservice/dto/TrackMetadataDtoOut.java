package io.github.ardonplay.metadataservice.dto;

import java.util.List;
import java.util.UUID;

public record TrackMetadataDtoOut(UUID id, String title, Long duration, String s3Path,
                                  String s3CoverPath) {

}
