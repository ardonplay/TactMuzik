package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.repository;

import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity.TrackEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<TrackEntity, UUID> {

}
