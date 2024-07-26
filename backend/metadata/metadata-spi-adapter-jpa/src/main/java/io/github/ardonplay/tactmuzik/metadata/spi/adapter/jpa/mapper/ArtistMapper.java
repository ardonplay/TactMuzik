package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.mapper;

import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataOutDto;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity.ArtistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

  @Mapping(target = "name", source = "entity.name")
  @Mapping(target = "genre", source = "entity.genre.name")
  @Mapping(target = "id", source = "entity.id")
  ArtistMetadataOutDto mapToArtistMetadataDtoOut(ArtistEntity entity);
}
