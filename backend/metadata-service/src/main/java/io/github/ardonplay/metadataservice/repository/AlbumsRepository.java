package io.github.ardonplay.metadataservice.repository;

import io.github.ardonplay.metadataservice.entity.AlbumEntity;
import io.github.ardonplay.metadataservice.entity.ArtistEntity;
import io.github.ardonplay.metadataservice.entity.GenreEntity;
import io.github.ardonplay.metadataservice.util.AlbumType;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<AlbumEntity, UUID> {

  Optional<AlbumEntity> findAllByTitleAndTypeAndAndArtistsIn(String title,
      AlbumType type,
      Set<ArtistEntity> artists);
}
