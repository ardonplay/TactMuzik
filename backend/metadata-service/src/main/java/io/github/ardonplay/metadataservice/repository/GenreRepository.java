package io.github.ardonplay.metadataservice.repository;

import io.github.ardonplay.metadataservice.entity.GenreEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

  Optional<GenreEntity> findByName(String name);
}
