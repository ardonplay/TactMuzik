package io.github.ardonplay.tactmuzik.metadata.api.spring.webmvc;

import com.devskiller.friendly_id.FriendlyId;
import io.github.ardonplay.tactmuzik.metadata.api.ArtistOperationsApi;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/metadata/artist")
@RequiredArgsConstructor
public class ArtistMetadataController {

  private final ArtistOperationsApi artistService;

  @GetMapping("/{id}")
  public ResponseEntity<ArtistMetadataOutDto> getArtistMetadata(@PathVariable("id") String id) {
    return new ResponseEntity<>(artistService.getArtist(FriendlyId.toUuid(id)).orElse(null), HttpStatus.OK);
  }

}
