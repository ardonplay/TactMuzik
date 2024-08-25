package io.github.ardonplay.metadataservice.exception;

public class AlbumAlreadyExistsException extends MetadataAlreadyExistsException {

  public AlbumAlreadyExistsException(String message) {
    super(message);
  }

  public AlbumAlreadyExistsException() {
    super("Album already exists");
  }
}
