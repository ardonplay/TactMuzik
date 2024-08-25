package io.github.ardonplay.metadataservice.service.impl;

import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.TrackEntity;
import io.github.ardonplay.metadataservice.exception.TrackNotFoundException;
import io.github.ardonplay.metadataservice.repository.TrackRepository;
import io.github.ardonplay.metadataservice.service.AlbumService;
import io.github.ardonplay.metadataservice.service.ArtistService;
import io.github.ardonplay.metadataservice.service.TrackService;
import io.github.ardonplay.metadataservice.util.mapper.TrackMapper;
import java.sql.Time;
import java.time.LocalTime;
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


  @Override
  public TrackMetadataDtoOut getTrackMetadata(UUID trackId) {
    return trackMapper.mapToTrackMetadataDtoOut(
        trackRepository.findById(trackId).orElseThrow(TrackNotFoundException::new));
  }

  @Override
  @Transactional
  public TrackMetadataDtoOut addTrackMetadata(TrackMetadataDtoIn trackMetadataDtoIn) {
    TrackEntity newTrack = new TrackEntity(
        UUID.randomUUID(),
        trackMetadataDtoIn.title(),
        Time.valueOf(
            LocalTime.ofSecondOfDay(trackMetadataDtoIn.duration())),
        trackMetadataDtoIn.s3Path(),
        trackMetadataDtoIn.s3CoverPath());

    return trackMapper.mapToTrackMetadataDtoOut(trackRepository.save(newTrack));

  }

  @Override
  public TrackMetadataDtoOut updateTrackMetadata(TrackMetadataDtoOut trackMetadataDtoOut) {
    TrackEntity trackEntity = trackRepository.findById(trackMetadataDtoOut.id())
        .orElseThrow(TrackNotFoundException::new);
    trackMapper.updateTrackEntityFromTrackMetadataDto(trackMetadataDtoOut, trackEntity);
    return trackMapper.mapToTrackMetadataDtoOut(trackRepository.save(trackEntity));
  }

  @Override
  public void deleteTrackMetadata(UUID trackId) {
    trackRepository.deleteById(trackId);
  }

}
