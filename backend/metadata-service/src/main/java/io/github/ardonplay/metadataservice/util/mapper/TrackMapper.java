package io.github.ardonplay.metadataservice.util.mapper;

import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.TrackEntity;
import java.sql.Time;
import java.time.LocalTime;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    uses = {ArtistMapper.class})
public interface TrackMapper {

  @Mapping(target = "duration", expression = "java(entity.getDuration() != null ? entity.getDuration().toLocalTime().toSecondOfDay() : 0L)")
  TrackMetadataDtoOut mapToTrackMetadataDtoOut(TrackEntity entity);

  @Mapping(target = "duration", qualifiedByName = "longToTime")
  void updateTrackEntityFromTrackMetadataDto(TrackMetadataDtoOut trackMetadataDtoOut,
      @MappingTarget TrackEntity trackEntity);

  @Named("longToTime")
  default Time longToTime(Long source) {
    return Time.valueOf(LocalTime.ofSecondOfDay(source));
  }
}
