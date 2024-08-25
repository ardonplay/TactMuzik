package io.github.ardonplay.metadataservice.controller;

import com.devskiller.friendly_id.FriendlyId;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoOut;
import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoOut;
import io.github.ardonplay.metadataservice.service.ArtistService;
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
@RequestMapping("/api/v1/metadata/artist")
public class ArtistController {

  private final ArtistService artistService;

  @GetMapping("/{id}")
  public ResponseEntity<ArtistMetadataDtoOut> getAlbumMetadata(@PathVariable("id") String id) {
    return new ResponseEntity<>(
        artistService.getArtistMetadata(FriendlyId.toUuid(id)),
        HttpStatus.OK);
  }

  @PostMapping("/new")
  public ResponseEntity<Void> addArtistMetadata(
      @RequestBody ArtistMetadataDtoIn artistMetadataDtoIn) {
    artistService.addArtistMetadata(artistMetadataDtoIn);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PatchMapping
  public ResponseEntity<ArtistMetadataDtoOut> updateArtistMetadata(
      @RequestBody ArtistMetadataDtoOut artistMetadataDtoOut) {
    artistService.updateArtistMetadata(artistMetadataDtoOut);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAlbumMetadata(@PathVariable("id") String id) {
    artistService.deleteArtist(FriendlyId.toUuid(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

}

