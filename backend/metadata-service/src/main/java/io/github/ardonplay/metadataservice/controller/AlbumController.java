package io.github.ardonplay.metadataservice.controller;

import com.devskiller.friendly_id.FriendlyId;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoOut;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataUpdateDto;
import io.github.ardonplay.metadataservice.service.AlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/metadata/album")
public class AlbumController {

  private final AlbumService albumService;

  @GetMapping("/{id}")
  public ResponseEntity<AlbumMetadataDtoOut> getAlbumMetadata(@PathVariable("id") String id) {
    return new ResponseEntity<>(
        albumService.getAlbumMetadata(FriendlyId.toUuid(id)),
        HttpStatus.OK);
  }

  @PostMapping("/new")
  public ResponseEntity<Void> addAlbumMetadata(@RequestBody AlbumMetadataDtoIn albumMetadata) {
    log.info("NEW ALBUM {}", albumMetadata);
    albumService.addAlbumMetadata(albumMetadata);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PatchMapping
  public ResponseEntity<AlbumMetadataDtoOut> updateAlbumMetadata(
      @RequestBody AlbumMetadataUpdateDto albumMetadata) {
    albumService.updateAlbumMetadata(albumMetadata);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAlbumMetadata(@PathVariable("id") String id) {
    albumService.deleteAlbumMetadata(FriendlyId.toUuid(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

}

