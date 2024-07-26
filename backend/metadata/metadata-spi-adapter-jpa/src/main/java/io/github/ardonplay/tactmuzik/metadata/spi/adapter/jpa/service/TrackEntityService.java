package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.service;

import io.github.ardonplay.tactmuzik.metadata.shared.data.TrackData;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.TrackMetadataOutDto;
import io.github.ardonplay.tactmuzik.metadata.spi.TrackSpi;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity.TrackEntity;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.mapper.TrackMapper;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.repository.TrackRepository;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrackEntityService implements TrackSpi {

  private final TrackRepository trackRepository;

  private final TrackMapper trackMapper;

  private final ArtistEntityService artistService;

  private final AlbumEntityService albumService;

  private final GenreEntityService genreService;

  @Override
  public TrackMetadataOutDto getTrackMetadata(UUID trackId) {
    return trackMapper.mapToTrackMetadataDtoOut(trackRepository.findById(trackId).orElseThrow());
  }

  @Override
  @Transactional
  public TrackMetadataOutDto addTrackMetadata(TrackMetadataInDto trackMetadataDtoIn) {
    TrackEntity newTrack = new TrackEntity(UUID.randomUUID(), trackMetadataDtoIn.title(),
        Time.valueOf(
            LocalTime.ofSecondOfDay(trackMetadataDtoIn.duration())), trackMetadataDtoIn.s3Path(),
        trackMetadataDtoIn.s3CoverPath());

    newTrack.getArtists().addAll(new HashSet<>(artistService.getArtistsEntities(
        trackMetadataDtoIn.artists())));

    log.info("new track artist: {}", newTrack.getArtists());

    newTrack.setAlbums(new HashSet<>(albumService.getAlbumsEntities(
        trackMetadataDtoIn.albums())));

    log.info("new track albums: {}", newTrack.getAlbums());

    newTrack.setGenre(genreService.getGenreEntityByName(trackMetadataDtoIn.genre()));

    return trackMapper.mapToTrackMetadataDtoOut(trackRepository.save(newTrack));

  }

  @Override
  public TrackMetadataOutDto updateTrackMetadata(TrackMetadataOutDto trackMetadata) {
    return null;
  }

  @Override
  public void deleteTrackMetadata(UUID trackId) {

  }

  @Override
  public TrackData getTrack(UUID trackId) {
    return null;
  }

  @Override
  public List<TrackData> getTracks(Collection<UUID> trackIds) {
    return List.of();
  }
}
