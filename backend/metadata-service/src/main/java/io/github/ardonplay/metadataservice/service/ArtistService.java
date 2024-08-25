package io.github.ardonplay.metadataservice.service;

import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoOut;
import io.github.ardonplay.metadataservice.exception.ArtistNotFoundException;
import java.util.UUID;

public interface ArtistService {

  ArtistMetadataDtoOut getArtistMetadata(UUID artistId) throws ArtistNotFoundException;

  void deleteArtist(UUID artistId) throws ArtistNotFoundException;

  ArtistMetadataDtoOut addArtistMetadata(ArtistMetadataDtoIn artistMetadataDtoIn);

  ArtistMetadataDtoOut updateArtistMetadata(ArtistMetadataDtoOut artistMetadataDtoOut)
      throws ArtistNotFoundException;
}
