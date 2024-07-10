package io.github.ardonplay.metadataservice.repository;

import io.github.ardonplay.metadataservice.entity.TrackEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<TrackEntity, UUID> {

}
