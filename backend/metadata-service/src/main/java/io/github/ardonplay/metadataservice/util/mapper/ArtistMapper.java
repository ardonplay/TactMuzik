package io.github.ardonplay.metadataservice.util.mapper;

import io.github.ardonplay.metadataservice.dto.ArtistMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.ArtistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

  ArtistMetadataDtoOut mapToArtistMetadataDtoOut(ArtistEntity entity);

}
