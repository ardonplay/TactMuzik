package io.github.ardonplay.metadataservice.service.impl;

import com.devskiller.friendly_id.FriendlyId;
import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.TrackEntity;
import io.github.ardonplay.metadataservice.repository.TrackRepository;
import io.github.ardonplay.metadataservice.service.AlbumService;
import io.github.ardonplay.metadataservice.service.ArtistService;
import io.github.ardonplay.metadataservice.service.GenreService;
import io.github.ardonplay.metadataservice.service.TrackService;
import io.github.ardonplay.metadataservice.util.mapper.TrackMapper;
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
public class TrackMetadataServiceImpl implements TrackService {

  private final TrackRepository trackRepository;

  private final TrackMapper trackMapper;

  private final ArtistService artistService;

  private final AlbumService albumService;

  private final GenreService genreService;

  @Override
  public TrackMetadataDtoOut getTrackMetadata(UUID trackId) {
    return trackMapper.mapToTrackMetadataDtoOut(trackRepository.findById(trackId).orElseThrow());
  }

  @Override
  @Transactional
  public TrackMetadataDtoOut addTrackMetadata(TrackMetadataDtoIn trackMetadataDtoIn) {
    TrackEntity newTrack = new TrackEntity(UUID.randomUUID(), trackMetadataDtoIn.title(),
        Time.valueOf(
            LocalTime.ofSecondOfDay(trackMetadataDtoIn.duration())), trackMetadataDtoIn.s3Path(),
        trackMetadataDtoIn.s3CoverPath());

    newTrack.getArtists().addAll(new HashSet<>(artistService.getArtists(
        trackMetadataDtoIn.artists().stream().map(FriendlyId::toUuid).toList())));

    log.info("new track artist: {}", newTrack.getArtists());

    newTrack.setAlbums(new HashSet<>(albumService.getAlbums(
        trackMetadataDtoIn.albums().stream().map(FriendlyId::toUuid).toList())));
    log.info("new track albums: {}", newTrack.getAlbums());

    newTrack.setGenre(genreService.getByName(trackMetadataDtoIn.genre()));

    return trackMapper.mapToTrackMetadataDtoOut(trackRepository.save(newTrack));

  }

  @Override
  public void deleteTrackMetadata(UUID trackId) {

  }

  @Override
  public TrackEntity getTrack(UUID trackId) {
    return null;
  }

  @Override
  public List<TrackEntity> getTracks(Collection<UUID> trackIds) {
    return List.of();
  }
}
