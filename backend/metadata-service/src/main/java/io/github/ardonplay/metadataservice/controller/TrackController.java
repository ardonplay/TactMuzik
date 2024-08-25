package io.github.ardonplay.metadataservice.controller;

import com.devskiller.friendly_id.FriendlyId;
import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoOut;
import io.github.ardonplay.metadataservice.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/metadata/track")
public class TrackController {

  private final TrackService trackService;

  @GetMapping("/{id}")
  public ResponseEntity<TrackMetadataDtoOut> getTrackMetadata(@PathVariable("id") String id) {
    return new ResponseEntity<>(
        trackService.getTrackMetadata(FriendlyId.toUuid(id)),
        HttpStatus.OK);
  }

  @PostMapping("/new")
  public ResponseEntity<Void> addTrackMetadataIntoAlbum(
      @RequestBody TrackMetadataDtoIn trackMetadataDtoIn) {
    //TODO добавление нового трека в существующий альбом
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PatchMapping
  public ResponseEntity<TrackMetadataDtoOut> updateTrackMetadata(
      @RequestBody TrackMetadataDtoOut trackMetadataDtoOut) {
    return new ResponseEntity<>(trackService.updateTrackMetadata(trackMetadataDtoOut),
        HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAlbumMetadata(@PathVariable("id") String id) {
    trackService.deleteTrackMetadata(FriendlyId.toUuid(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

}

