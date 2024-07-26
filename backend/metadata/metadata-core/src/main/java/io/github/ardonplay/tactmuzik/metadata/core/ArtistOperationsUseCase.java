package io.github.ardonplay.tactmuzik.metadata.core;

import io.github.ardonplay.tactmuzik.metadata.api.ArtistOperationsApi;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataOutDto;
import io.github.ardonplay.tactmuzik.metadata.spi.ArtistSpi;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistOperationsUseCase implements ArtistOperationsApi {

  private final ArtistSpi artistSpi;

  @Override
  public Optional<ArtistMetadataOutDto> addArtist(ArtistMetadataInDto artist) {
    return Optional.of(artistSpi.addArtistMetadata(artist));
  }

  @Override
  public Optional<ArtistMetadataOutDto> updateArtist(ArtistMetadataOutDto artist) {
    return Optional.of(artistSpi.updateArtistMetadata(artist));
  }

  @Override
  public void deleteArtist(UUID artistId) {
    artistSpi.deleteArtistMetadata(artistId);
  }

  @Override
  public Optional<ArtistMetadataOutDto> getArtist(UUID artistId) {
    return Optional.of(artistSpi.getArtistMetadata(artistId));
  }
}
