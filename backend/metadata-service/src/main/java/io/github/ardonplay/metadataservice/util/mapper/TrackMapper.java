package io.github.ardonplay.metadataservice.util.mapper;

import io.github.ardonplay.metadataservice.dto.TrackMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.TrackEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    uses = {ArtistMapper.class})
public interface TrackMapper {

  @Mapping(target = "id", expression = "java(com.devskiller.friendly_id.FriendlyId.toFriendlyId(entity.getId()))")
  @Mapping(target = "title", source = "entity.title")
  @Mapping(target = "duration",expression = "java(entity.getDuration() != null ? entity.getDuration().toLocalTime().toSecondOfDay() : 0L)")
  @Mapping(target = "s3Path", source = "entity.s3Path")
  @Mapping(target = "s3CoverPath", source = "entity.s3CoverPath")
  @Mapping(target = "artists", source = "entity.artists")
  TrackMetadataDtoOut mapToTrackMetadataDtoOut(TrackEntity entity);
}
