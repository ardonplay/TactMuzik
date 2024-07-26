package io.github.ardonplay.tactmuzik.uploader.api;

import io.github.ardonplay.tactmuzik.uploader.shared.dto.UploadDataOutDto;
import java.io.File;
import java.util.Optional;

@FunctionalInterface
public interface UploadFileApi {

  Optional<UploadDataOutDto> uploadTrack(File file);

}
