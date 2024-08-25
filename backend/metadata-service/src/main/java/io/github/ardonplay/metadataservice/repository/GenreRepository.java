package io.github.ardonplay.metadataservice.repository;

import io.github.ardonplay.metadataservice.entity.GenreEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

  Optional<GenreEntity> findByName(String name);

  List<GenreEntity> findGenreEntitiesByNameIn(@Param("names") List<String> name);

}
