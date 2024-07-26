package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.repository;

import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity.AlbumEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<AlbumEntity, UUID> {

}
