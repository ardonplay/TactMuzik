package io.github.ardonplay.metadataservice.exception;

public class TrackNotFoundException extends MetadataNotFoundException {

  public TrackNotFoundException(String message) {
    super(message);
  }

  public TrackNotFoundException() {
    super("Track not found");
  }
}
