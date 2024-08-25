package io.github.ardonplay.metadataservice.service.impl;

import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoOut;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataUpdateDto;
import io.github.ardonplay.metadataservice.entity.AlbumEntity;
import io.github.ardonplay.metadataservice.entity.ArtistEntity;
import io.github.ardonplay.metadataservice.entity.GenreEntity;
import io.github.ardonplay.metadataservice.entity.TrackEntity;
import io.github.ardonplay.metadataservice.exception.AlbumAlreadyExistsException;
import io.github.ardonplay.metadataservice.exception.AlbumNotFoundException;
import io.github.ardonplay.metadataservice.repository.AlbumsRepository;
import io.github.ardonplay.metadataservice.repository.ArtistsRepository;
import io.github.ardonplay.metadataservice.repository.GenreRepository;
import io.github.ardonplay.metadataservice.service.AlbumService;
import io.github.ardonplay.metadataservice.util.mapper.AlbumMapper;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlbumMetadataServiceImpl implements AlbumService {

  private final AlbumsRepository albumsRepository;
  private final ArtistsRepository artistsRepository;
  private final GenreRepository genreRepository;


  private final AlbumMapper albumMapper;

  @Override
  public AlbumMetadataDtoOut getAlbumMetadata(UUID albumId) {
    return albumMapper.mapToAlbumMetadataDtoOut(albumsRepository.findById(albumId).orElseThrow(AlbumNotFoundException::new));
  }

  @Override
  public void deleteAlbumMetadata(UUID albumId) {
    albumsRepository.deleteById(albumId);
  }

  @Override
  @Transactional
  public AlbumMetadataDtoOut addAlbumMetadata(AlbumMetadataDtoIn albumMetadataDtoIn) {
    Set<ArtistEntity> artists = artistsRepository.findArtistEntitiesByIdIn(
        albumMetadataDtoIn.artists().stream().map(UUID::toString).toList());
    List<GenreEntity> genres = genreRepository.findGenreEntitiesByNameIn(
        albumMetadataDtoIn.genres());

    Optional<AlbumEntity> existingAlbum = albumsRepository.findAllByTitleAndTypeAndAndArtistsIn(
        albumMetadataDtoIn.title(), albumMetadataDtoIn.type(),
        artists);

    if (existingAlbum.isPresent()) {
      throw new AlbumAlreadyExistsException();
    }

    AlbumEntity albumEntity = new AlbumEntity();
    albumEntity.setTitle(albumMetadataDtoIn.title());
    albumEntity.setType(albumMetadataDtoIn.type());
    albumEntity.setReleaseDate(new java.sql.Date(albumMetadataDtoIn.releaseDate().getTime()));
    albumEntity.setArtists(artists);
    albumEntity.setGenres(genres);

    List<TrackEntity> tracks = albumMetadataDtoIn.tracks().stream()
        .map(trackDto -> {
          TrackEntity track = new TrackEntity();
          track.setTitle(trackDto.title());
          track.setDuration(new Time(trackDto.duration()));
          track.setS3Path(trackDto.s3Path());
          track.setS3CoverPath(trackDto.s3CoverPath());
          return track;
        }).toList();
    albumEntity.setTracks(new HashSet<>(tracks));

    return albumMapper.mapToAlbumMetadataDtoOut(albumsRepository.save(albumEntity));

  }

  @Override
  public AlbumMetadataDtoOut updateAlbumMetadata(AlbumMetadataUpdateDto albumMetadataUpdateDto) {
    Set<ArtistEntity> artists = artistsRepository.findArtistEntitiesByIdIn(
        albumMetadataUpdateDto.artists().stream().map(UUID::toString).toList());
    List<GenreEntity> genres = genreRepository.findGenreEntitiesByNameIn(
        albumMetadataUpdateDto.genres());

    AlbumEntity album = albumsRepository.findById(albumMetadataUpdateDto.id())
        .orElseThrow(AlbumNotFoundException::new);

    album.setTitle(albumMetadataUpdateDto.title());
    album.setType(albumMetadataUpdateDto.type());
    album.setReleaseDate(new java.sql.Date(albumMetadataUpdateDto.releaseDate().getTime()));
    album.setArtists(artists);
    album.setGenres(genres);

    return albumMapper.mapToAlbumMetadataDtoOut(albumsRepository.save(album));
  }
}
