package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.service;

import io.github.ardonplay.tactmuzik.metadata.shared.data.GenreData;
import io.github.ardonplay.tactmuzik.metadata.spi.GenreSpi;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity.GenreEntity;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreEntityService implements GenreSpi {

  private final GenreRepository genreRepository;

  @Override
  public GenreData create(GenreData genre) {
    return null;
  }

  @Override
  public void delete(int id) {

  }

  @Override
  public GenreData get(int id) {
//    return genreRepository.findById(id).orElse(null);
    return null;
  }

  @Override
  public GenreData getByName(String name) {
    return null;
//    return genreRepository.findByName(name).orElse(null) ;
  }

  public GenreEntity getGenreEntityByName(String name) {
    return genreRepository.findByName(name).orElse(null) ;
  }
}
