package io.github.ardonplay.metadataservice.service;

import io.github.ardonplay.metadataservice.entity.GenreEntity;

public interface GenreService {
  GenreEntity create(GenreEntity genre);

  GenreEntity delete(int id);

  GenreEntity get(int id);

  GenreEntity getByName(String name);
}
