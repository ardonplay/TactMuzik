package io.github.ardonplay.metadataservice.util.mapper;

import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.AlbumEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    uses = {ArtistMapper.class, TrackMapper.class, GenreMapper.class})
public interface AlbumMapper {

  AlbumMetadataDtoOut mapToAlbumMetadataDtoOut(AlbumEntity entity);

}
