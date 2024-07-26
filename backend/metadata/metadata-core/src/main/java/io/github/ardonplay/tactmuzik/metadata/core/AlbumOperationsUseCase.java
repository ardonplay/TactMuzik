package io.github.ardonplay.tactmuzik.metadata.core;

import io.github.ardonplay.tactmuzik.metadata.api.AlbumOperationsApi;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataOutDto;
import io.github.ardonplay.tactmuzik.metadata.spi.AlbumSpi;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumOperationsUseCase implements AlbumOperationsApi {

  private final AlbumSpi albumSpi;

  @Override
  public Optional<AlbumMetadataOutDto> createAlbum(AlbumMetadataInDto album) {
    return Optional.of(albumSpi.addAlbumMetadata(album));
  }

  @Override
  public void deleteAlbum(UUID albumId) {
    albumSpi.deleteAlbumMetadata(albumId);
  }

  @Override
  public Optional<AlbumMetadataOutDto> getAlbum(UUID albumId) {
    return Optional.of(albumSpi.getAlbumMetadata(albumId));
  }

  @Override
  public Optional<AlbumMetadataOutDto> updateAlbum(AlbumMetadataOutDto album) {
    return Optional.of(albumSpi.updateAlbumMetadata(album));
  }
}
