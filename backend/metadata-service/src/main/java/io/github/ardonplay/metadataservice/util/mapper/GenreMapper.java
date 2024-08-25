package io.github.ardonplay.metadataservice.util.mapper;

import io.github.ardonplay.metadataservice.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface GenreMapper {

  default String mapToString(GenreEntity genre) {
    return genre.getName();
  }

}
