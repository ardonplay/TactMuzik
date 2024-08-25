package io.github.ardonplay.metadataservice.repository;

import io.github.ardonplay.metadataservice.entity.ArtistEntity;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends JpaRepository<ArtistEntity, UUID> {

  Set<ArtistEntity> findArtistEntitiesByIdIn(@Param("names") List<String> names);

  Optional<ArtistEntity> findArtistEntityByName(String name);
}
