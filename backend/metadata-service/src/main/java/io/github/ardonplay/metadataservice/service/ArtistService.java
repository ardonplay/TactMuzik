package io.github.ardonplay.metadataservice.service;

import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.ArtistEntity;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface ArtistService {

  ArtistMetadataDtoOut addArtistMetadata(ArtistMetadataDtoIn artistMetadataDtoIn);

  void deleteArtistMetadata(UUID artistId);

  ArtistMetadataDtoOut getArtistMetadata(UUID artistId);

  ArtistEntity getArtist(UUID artistId);

  List<ArtistEntity> getArtists(Collection<UUID> artistId);
}
