package io.github.ardonplay.metadataservice.repository;

import io.github.ardonplay.metadataservice.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<GenreEntity, Integer> {

}
