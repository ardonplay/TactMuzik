package io.github.ardonplay.tactmuzik.uploader;

import io.github.ardonplay.tactmuzik.uploader.api.UploadFileApi;
import io.github.ardonplay.tactmuzik.uploader.config.LocationConfiguration;
import io.github.ardonplay.tactmuzik.uploader.shared.dto.UploadDataOutDto;
import io.github.ardonplay.tactmuzik.uploader.shared.services.UtilMethodsService;
import io.github.ardonplay.tactmuzik.uploader.spi.FileUploader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.datatype.Artwork;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackUploader implements UploadFileApi {

  private final FileUploader objectUploader;

  private final LocationConfiguration locationConfiguration;

  @Override
  public Optional<UploadDataOutDto> uploadTrack(File file) {
    try {
      UploadDataOutDto dto = new UploadDataOutDto();

      AudioFile audioFile = AudioFileIO.read(file);

      Tag tag = audioFile.getTag();

      if (!tag.getArtworkList().isEmpty()) {
        Artwork cover = tag.getFirstArtwork();
        String coverId = UtilMethodsService.calculateMD5(cover.getBinaryData());
        InputStream coverInputStream = new ByteArrayInputStream(cover.getBinaryData());
        objectUploader.uploadFile(coverId, locationConfiguration.coverBucket, cover.getMimeType(), coverInputStream);
        coverInputStream.close();
        dto.setCoverId(coverId);
      }

      String trackId = UtilMethodsService.calculateMD5(file);
      InputStream trackInputStream = new FileInputStream(file);
      objectUploader.uploadFile(trackId, locationConfiguration.trackBucket, "audio/mpeg", trackInputStream);
      trackInputStream.close();
      dto.setTrackId(trackId);

      return Optional.of(dto);
    }catch (Exception e){
      return Optional.empty();
    }
  }
}
