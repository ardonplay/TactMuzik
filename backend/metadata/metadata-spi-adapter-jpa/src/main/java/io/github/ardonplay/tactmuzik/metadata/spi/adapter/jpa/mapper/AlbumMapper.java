package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.mapper;


import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataOutDto;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity.AlbumEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
injectionStrategy = InjectionStrategy.CONSTRUCTOR,
uses = {ArtistMapper.class, TrackMapper.class})
public interface AlbumMapper {

  @Mapping(target = "id", source = "entity.id")
  @Mapping(target = "title", source = "entity.title")
  @Mapping(target = "type", source = "entity.type")
  @Mapping(target = "artists", source = "entity.artists")
  @Mapping(target = "tracks", source = "entity.tracks")
  @Mapping(target = "releaseDate", source = "entity.releaseDate")
  AlbumMetadataOutDto mapToAlbumMetadataDtoOut(AlbumEntity entity);

}
