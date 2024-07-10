package io.github.ardonplay.metadataservice.service.impl;

import io.github.ardonplay.metadataservice.entity.GenreEntity;
import io.github.ardonplay.metadataservice.repository.GenreRepository;
import io.github.ardonplay.metadataservice.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreEntityImpl implements GenreService {

  private final GenreRepository genreRepository;

  @Override
  public GenreEntity create(GenreEntity genre) {
    return null;
  }

  @Override
  public GenreEntity delete(int id) {
    return null;
  }

  @Override
  public GenreEntity get(int id) {
    return genreRepository.findById(id).orElse(null);
  }

  @Override
  public GenreEntity getByName(String name) {
    return genreRepository.findByName(name).orElse(null) ;
  }
}
