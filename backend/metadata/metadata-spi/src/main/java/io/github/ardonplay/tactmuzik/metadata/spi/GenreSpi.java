package io.github.ardonplay.tactmuzik.metadata.spi;


import io.github.ardonplay.tactmuzik.metadata.shared.data.GenreData;

public interface GenreSpi {

  GenreData create(GenreData genre);

  void delete(int id);

  GenreData get(int id);

  GenreData getByName(String name);
}
