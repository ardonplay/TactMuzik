package io.github.ardonplay.metadataservice.service;

import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.AlbumEntity;
import java.util.Collection;
import java.util.UUID;

public interface AlbumService {

  AlbumMetadataDtoOut getAlbumMetadata(UUID albumId);

  void deleteAlbumMetadata(UUID albumId);

  AlbumMetadataDtoOut addAlbumMetadata(AlbumMetadataDtoIn albumMetadataDtoIn);

  AlbumEntity getAlbum(UUID albumId);

  Collection<AlbumEntity> getAlbums(Collection<UUID> albumIds);
}
