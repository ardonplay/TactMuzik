package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.service;

import io.github.ardonplay.tactmuzik.metadata.shared.data.AlbumData;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataOutDto;
import io.github.ardonplay.tactmuzik.metadata.spi.AlbumSpi;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity.AlbumEntity;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.mapper.AlbumMapper;
import io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.repository.AlbumsRepository;
import java.util.Collection;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumEntityService implements AlbumSpi {

  private final AlbumsRepository albumsRepository;

  private final AlbumMapper albumMapper;

  @Override
  public AlbumMetadataOutDto getAlbumMetadata(UUID albumId) {
    return albumMapper.mapToAlbumMetadataDtoOut(albumsRepository.findById(albumId).orElse(null));
  }

  @Override
  public AlbumMetadataOutDto updateAlbumMetadata(AlbumMetadataOutDto albumMetadataOutDto) {
    return null;
  }

  @Override
  public void deleteAlbumMetadata(UUID albumId) {

  }

  @Override
  public AlbumMetadataOutDto addAlbumMetadata(AlbumMetadataInDto albumMetadataDtoIn) {
    return null;
  }

  @Override
  public AlbumData getAlbum(UUID albumId) {
    return null;
  }

  @Override
  public Collection<AlbumData> getAlbums(Collection<UUID> albumIds) {
//    return albumsRepository.findAllById(albumIds);
    return null;
  }

  public Collection<AlbumEntity> getAlbumsEntities(Collection<UUID> albumIds) {
    return albumsRepository.findAllById(albumIds);
  }
}
