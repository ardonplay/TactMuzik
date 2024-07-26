package io.github.ardonplay.tactmuzik.metadata.api.spring.webmvc;

import com.devskiller.friendly_id.FriendlyId;
import io.github.ardonplay.tactmuzik.metadata.api.TrackOperationsApi;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataOutDto;
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
@RequestMapping("/api/v1/metadata/track")
@RequiredArgsConstructor
public class TrackMetadataController {

  private final TrackOperationsApi trackOperationsApi;

  @GetMapping("/{id}")
  public ResponseEntity<TrackMetadataOutDto> getTrackMetadata(@PathVariable("id") String id) {
    return new ResponseEntity<>(
        trackOperationsApi.getTrackMetadata(FriendlyId.toUuid(id)).orElse(null), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<TrackMetadataOutDto> addTrackMetadata(
      @RequestBody TrackMetadataInDto trackMetadataDtoIn) {
    return new ResponseEntity<>(trackOperationsApi.createTrack(trackMetadataDtoIn).orElse(null),
        HttpStatus.CREATED);
  }



}
