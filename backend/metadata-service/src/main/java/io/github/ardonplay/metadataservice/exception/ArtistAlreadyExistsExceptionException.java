package io.github.ardonplay.metadataservice.exception;

public class ArtistAlreadyExistsExceptionException extends MetadataAlreadyExistsException {

  public ArtistAlreadyExistsExceptionException(String message) {
    super(message);
  }

  public ArtistAlreadyExistsExceptionException() {
    super("Artist already exists");
  }
}
