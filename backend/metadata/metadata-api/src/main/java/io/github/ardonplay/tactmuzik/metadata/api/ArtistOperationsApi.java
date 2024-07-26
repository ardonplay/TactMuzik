package io.github.ardonplay.tactmuzik.metadata.api;

import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataOutDto;
import java.util.Optional;
import java.util.UUID;

public interface ArtistOperationsApi {

  Optional<ArtistMetadataOutDto> addArtist(ArtistMetadataInDto artist);

  Optional<ArtistMetadataOutDto> updateArtist(ArtistMetadataOutDto artist);

  void deleteArtist(UUID artistId);

  Optional<ArtistMetadataOutDto> getArtist(UUID artistId);
}
