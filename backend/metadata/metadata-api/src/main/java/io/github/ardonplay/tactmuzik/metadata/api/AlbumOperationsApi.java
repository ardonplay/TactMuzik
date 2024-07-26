package io.github.ardonplay.tactmuzik.metadata.api;

import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataOutDto;
import java.util.Optional;
import java.util.UUID;

public interface AlbumOperationsApi {

  Optional<AlbumMetadataOutDto> createAlbum(AlbumMetadataInDto album);

  void deleteAlbum(UUID albumId);

  Optional<AlbumMetadataOutDto> getAlbum(UUID albumId);

  Optional<AlbumMetadataOutDto> updateAlbum(AlbumMetadataOutDto album);
}
