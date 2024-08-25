package io.github.ardonplay.metadataservice.service;

import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoOut;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataUpdateDto;
import io.github.ardonplay.metadataservice.entity.AlbumEntity;
import io.github.ardonplay.metadataservice.exception.AlbumNotFoundException;
import io.github.ardonplay.metadataservice.exception.ArtistNotFoundException;
import io.github.ardonplay.metadataservice.exception.TrackNotFoundException;
import java.util.Collection;
import java.util.UUID;

public interface AlbumService {

  AlbumMetadataDtoOut getAlbumMetadata(UUID albumId) throws AlbumNotFoundException;

  void deleteAlbumMetadata(UUID albumId) throws AlbumNotFoundException;

  AlbumMetadataDtoOut addAlbumMetadata(AlbumMetadataDtoIn albumMetadataDtoIn) throws ArtistNotFoundException;

  AlbumMetadataDtoOut updateAlbumMetadata(AlbumMetadataUpdateDto albumMetadataUpdateDto);
}
