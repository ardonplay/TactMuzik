package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.service;

import io.github.ardonplay.tactmuzik.metadata.shared.data.ArtistData;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataOutDto;
import io.github.ardonplay.tactmuzik.metadata.spi.ArtistSpi;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity.ArtistEntity;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.mapper.ArtistMapper;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.repository.ArtistsRepository;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistEntityService implements ArtistSpi {

  private final ArtistsRepository artistsRepository;

  private final ArtistMapper artistMapper;

  private final GenreEntityService genreService;

  @Override
  public ArtistMetadataOutDto addArtistMetadata(ArtistMetadataInDto artistMetadataDtoIn) {
      return artistMapper.mapToArtistMetadataDtoOut(artistsRepository.save(new ArtistEntity(UUID.randomUUID(), artistMetadataDtoIn.name(), genreService.getGenreEntityByName(artistMetadataDtoIn.genre()))));
  }

  @Override
  public void deleteArtistMetadata(UUID artistId) {

  }

  @Override
  public ArtistMetadataOutDto getArtistMetadata(UUID artistId) {
    return artistMapper.mapToArtistMetadataDtoOut(artistsRepository.findById(artistId).orElse(null));
  }

  @Override
  public ArtistMetadataOutDto updateArtistMetadata(ArtistMetadataOutDto artistMetadataOutDto) {
    return null;
  }

  @Override
  public ArtistData getArtist(UUID artistId) {
    return null;
  }

  @Override
  public List<ArtistData> getArtists(Collection<UUID> artistId) {
   return null;
  }

  protected List<ArtistEntity> getArtistsEntities(Collection<UUID> artistId) {
    return artistsRepository.findAllById(artistId);
  }
}
