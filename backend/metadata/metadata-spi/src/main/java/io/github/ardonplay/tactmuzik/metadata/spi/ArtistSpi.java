package io.github.ardonplay.tactmuzik.metadata.spi;

import io.github.ardonplay.tactmuzik.metadata.shared.data.ArtistData;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataInDto;
import io.github.ardonplay.tactmuzik.metadata.shared.dto.ArtistMetadataOutDto;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface ArtistSpi {

  ArtistMetadataOutDto addArtistMetadata(ArtistMetadataInDto artistMetadataDtoIn);

  void deleteArtistMetadata(UUID artistId);

  ArtistMetadataOutDto getArtistMetadata(UUID artistId);

  ArtistMetadataOutDto updateArtistMetadata(ArtistMetadataOutDto artistMetadataOutDto);

  ArtistData getArtist(UUID artistId);


  List<ArtistData> getArtists(Collection<UUID> artistId);
}
