package io.github.ardonplay.metadataservice.exception;

public class ArtistNotFoundException extends MetadataNotFoundException {

  public ArtistNotFoundException(String message) {
    super(message);
  }

  public ArtistNotFoundException() {
    super("Artist not found");
  }
}
