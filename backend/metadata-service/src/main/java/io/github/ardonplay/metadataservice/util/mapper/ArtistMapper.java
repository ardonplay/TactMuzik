package io.github.ardonplay.metadataservice.util.mapper;

import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.ArtistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

  @Mapping(target = "name", source = "entity.name")
  @Mapping(target = "genre", source = "entity.genre.name")
  @Mapping(target = "id", expression = "java(com.devskiller.friendly_id.FriendlyId.toFriendlyId(entity.getId()))")
  ArtistMetadataDtoOut mapToArtistMetadataDtoOut(ArtistEntity entity);
}
