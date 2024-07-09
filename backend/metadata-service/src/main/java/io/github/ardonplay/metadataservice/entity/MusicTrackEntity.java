package io.github.ardonplay.metadataservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "tracks")
@Data
public class MusicTrackEntity {

  @Id
  @GeneratedValue
  private UUID id;

  private String title;

  private Time duration;

  @Column(name = "s3_path")
  private String s3Path;

  @Column(name = "s3_cover_path")
  private String s3CoverPath;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private AlbumEntity album;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private ArtistEntity artist;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private GenreEntity genre;

}
