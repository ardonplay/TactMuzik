package io.github.ardonplay.metadataservice.service.impl;

import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.ArtistEntity;
import io.github.ardonplay.metadataservice.exception.ArtistAlreadyExistsExceptionException;
import io.github.ardonplay.metadataservice.exception.ArtistNotFoundException;
import io.github.ardonplay.metadataservice.repository.ArtistsRepository;
import io.github.ardonplay.metadataservice.service.ArtistService;
import io.github.ardonplay.metadataservice.util.mapper.ArtistMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistMetadataServiceImpl implements ArtistService {

  private final ArtistsRepository artistsRepository;

  private final ArtistMapper artistMapper;


  @Override
  public ArtistMetadataDtoOut addArtistMetadata(ArtistMetadataDtoIn artistMetadataDtoIn) {
    artistsRepository.findArtistEntityByName(artistMetadataDtoIn.name()).ifPresent(artistEntity -> {
      throw new ArtistAlreadyExistsExceptionException();
    });
    return artistMapper.mapToArtistMetadataDtoOut(
        artistsRepository.save(new ArtistEntity(UUID.randomUUID(), artistMetadataDtoIn.name())));
  }

  @Override
  public ArtistMetadataDtoOut updateArtistMetadata(ArtistMetadataDtoOut artistMetadataDtoOut)
      throws ArtistNotFoundException {
    ArtistEntity artist = artistsRepository.findById(artistMetadataDtoOut.id())
        .orElseThrow(ArtistNotFoundException::new);

    artist.setName(artistMetadataDtoOut.name());
    artist = artistsRepository.save(artist);

    return artistMapper.mapToArtistMetadataDtoOut(artist);
  }


  @Override
  public ArtistMetadataDtoOut getArtistMetadata(UUID artistId) {
    return artistMapper.mapToArtistMetadataDtoOut(
        artistsRepository.findById(artistId).orElse(null));
  }

  @Override
  public void deleteArtist(UUID artistId) throws ArtistNotFoundException {
    artistsRepository.deleteById(
        artistId); //TODO Возможно стоит удалять альбомы если артист является основным, типа например (Metallica, LadyGaga)
  }


}
