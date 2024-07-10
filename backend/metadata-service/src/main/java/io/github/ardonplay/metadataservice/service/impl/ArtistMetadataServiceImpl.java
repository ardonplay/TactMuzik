package io.github.ardonplay.metadataservice.service.impl;

import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.ArtistEntity;
import io.github.ardonplay.metadataservice.repository.ArtistsRepository;
import io.github.ardonplay.metadataservice.service.ArtistService;
import io.github.ardonplay.metadataservice.service.GenreService;
import io.github.ardonplay.metadataservice.util.mapper.ArtistMapper;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistMetadataServiceImpl implements ArtistService {

  private final ArtistsRepository artistsRepository;

  private final ArtistMapper artistMapper;

  private final GenreService genreService;

  @Override
  public ArtistMetadataDtoOut addArtistMetadata(ArtistMetadataDtoIn artistMetadataDtoIn) {
      return artistMapper.mapToArtistMetadataDtoOut(artistsRepository.save(new ArtistEntity(UUID.randomUUID(), artistMetadataDtoIn.name(), genreService.getByName(artistMetadataDtoIn.genre()))));
  }

  @Override
  public void deleteArtistMetadata(UUID artistId) {

  }

  @Override
  public ArtistMetadataDtoOut getArtistMetadata(UUID artistId) {
    return artistMapper.mapToArtistMetadataDtoOut(artistsRepository.findById(artistId).orElse(null));
  }

  @Override
  public ArtistEntity getArtist(UUID artistId) {
    return null;
  }

  @Override
  public List<ArtistEntity> getArtists(Collection<UUID> artistId) {
    return artistsRepository.findAllById(artistId);
  }
}
