package io.github.ardonplay.metadataservice.service.impl;

import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoIn;
import io.github.ardonplay.metadataservice.dto.AlbumMetadataDtoOut;
import io.github.ardonplay.metadataservice.entity.AlbumEntity;
import io.github.ardonplay.metadataservice.repository.AlbumsRepository;
import io.github.ardonplay.metadataservice.service.AlbumService;
import io.github.ardonplay.metadataservice.util.mapper.AlbumMapper;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumMetadataServiceImpl implements AlbumService {

  private final AlbumsRepository albumsRepository;

  private final AlbumMapper albumMapper;

  @Override
  public AlbumMetadataDtoOut getAlbumMetadata(UUID albumId) {
    return albumMapper.mapToAlbumMetadataDtoOut(albumsRepository.findById(albumId).orElse(null));
  }

  @Override
  public void deleteAlbumMetadata(UUID albumId) {

  }

  @Override
  public AlbumMetadataDtoOut addAlbumMetadata(AlbumMetadataDtoIn albumMetadataDtoIn) {
    return null;
  }

  @Override
  public AlbumEntity getAlbum(UUID albumId) {
    return null;
  }

  @Override
  public Collection<AlbumEntity> getAlbums(Collection<UUID> albumIds) {
    return albumsRepository.findAllById(albumIds);
  }
}
