package io.github.ardonplay.metadataservice.exception;

public class AlbumNotFoundException extends MetadataNotFoundException {

  public AlbumNotFoundException(String message) {
    super(message);
  }
  public AlbumNotFoundException() {
    super("Album not found");
  }
}
