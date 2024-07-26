package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.repository;

import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity.ArtistEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends JpaRepository<ArtistEntity, UUID> {

}
