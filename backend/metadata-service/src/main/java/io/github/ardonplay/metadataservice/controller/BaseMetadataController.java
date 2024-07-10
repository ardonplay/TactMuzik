package io.github.ardonplay.metadataservice.controller;

import com.devskiller.friendly_id.FriendlyId;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoOut;
import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoOut;
import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoOut;
import io.github.ardonplay.metadataservice.service.AlbumService;
import io.github.ardonplay.metadataservice.service.ArtistService;
import io.github.ardonplay.metadataservice.service.TrackService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/metadata/")
@RequiredArgsConstructor
public class BaseMetadataController {

  private final TrackService trackService;

  private final AlbumService albumService;

  private final ArtistService artistService;


  @GetMapping("/track/{id}")
  public ResponseEntity<TrackMetadataDtoOut> getTrackMetadata(@PathVariable("id") String id) {
    return new ResponseEntity<>(trackService.getTrackMetadata(FriendlyId.toUuid(id)), HttpStatus.OK);
  }

  @GetMapping("/album/{id}")
  public ResponseEntity<AlbumMetadataDtoOut> getAlbumMetadata(@PathVariable("id") String id) {
    return new ResponseEntity<>(albumService.getAlbumMetadata(FriendlyId.toUuid(id)), HttpStatus.OK);
  }

  @GetMapping("/artist/{id}")
  public ResponseEntity<ArtistMetadataDtoOut> getArtistMetadata(@PathVariable("id") String id) {
    return new ResponseEntity<>(artistService.getArtistMetadata(FriendlyId.toUuid(id)), HttpStatus.OK);
  }

  @PostMapping("/track/new")
  public ResponseEntity<TrackMetadataDtoOut> addTrackMetadata(@RequestBody TrackMetadataDtoIn trackMetadataDtoIn) {
    return new ResponseEntity<>(trackService.addTrackMetadata(trackMetadataDtoIn), HttpStatus.CREATED);
  }

  @GetMapping("/generate/{uuid}")
  public String generateFriendlyId(@PathVariable UUID uuid) {
    return FriendlyId.toFriendlyId(uuid);
  }


}
