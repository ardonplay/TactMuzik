package io.github.ardonplay.tactmuzik.metadata.spi;
import io.github.ardonplay.tactmuzik.metadata.shared.data.AlbumData;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.AlbumMetadataOutDto;
import java.util.Collection;
import java.util.UUID;

public interface AlbumSpi {

  AlbumMetadataOutDto getAlbumMetadata(UUID albumId);

  AlbumMetadataOutDto updateAlbumMetadata(AlbumMetadataOutDto albumMetadataOutDto);

  void deleteAlbumMetadata(UUID albumId);

  AlbumMetadataOutDto addAlbumMetadata(AlbumMetadataInDto albumMetadataDtoIn);

  AlbumData getAlbum(UUID albumId);

  Collection<AlbumData> getAlbums(Collection<UUID> albumIds);
}
