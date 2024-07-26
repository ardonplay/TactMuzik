package io.github.ardonplay.tactmuzik.metadata.api.spring.webmvc;

import com.devskiller.friendly_id.FriendlyId;
import io.github.ardonplay.tactmuzik.metadata.api.AlbumOperationsApi;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/metadata/album")
@RequiredArgsConstructor
public class AlbumMetadataController {

  private final AlbumOperationsApi albumOperationsApi;

  @GetMapping("/{id}")
  public ResponseEntity<AlbumMetadataOutDto> getAlbumMetadata(@PathVariable("id") String id) {
    return new ResponseEntity<>(albumOperationsApi.getAlbum(FriendlyId.toUuid(id)).orElse(null),
        HttpStatus.OK);
  }


}
