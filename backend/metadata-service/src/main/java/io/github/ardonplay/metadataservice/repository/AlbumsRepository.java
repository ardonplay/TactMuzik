package io.github.ardonplay.metadataservice.repository;

import io.github.ardonplay.metadataservice.entity.AlbumEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<AlbumEntity, UUID> {

}
