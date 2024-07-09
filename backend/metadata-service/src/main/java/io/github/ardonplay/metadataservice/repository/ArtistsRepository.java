package io.github.ardonplay.metadataservice.repository;

import io.github.ardonplay.metadataservice.entity.ArtistEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends JpaRepository<ArtistEntity, UUID> {

}
