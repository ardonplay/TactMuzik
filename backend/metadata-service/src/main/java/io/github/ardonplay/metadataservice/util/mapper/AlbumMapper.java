package io.github.ardonplay.metadataservice.util.mapper;

import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.AlbumEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
injectionStrategy = InjectionStrategy.CONSTRUCTOR,
uses = {ArtistMapper.class, TrackMapper.class})
public interface AlbumMapper {

  @Mapping(target = "id", expression = "java(com.devskiller.friendly_id.FriendlyId.toFriendlyId(entity.getId()))")
  @Mapping(target = "title", source = "entity.title")
  @Mapping(target = "type", source = "entity.type")
  @Mapping(target = "artists", source = "entity.artists")
  @Mapping(target = "tracks", source = "entity.tracks")
  @Mapping(target = "releaseDate", source = "entity.releaseDate")
  AlbumMetadataDtoOut mapToAlbumMetadataDtoOut(AlbumEntity entity);

}
