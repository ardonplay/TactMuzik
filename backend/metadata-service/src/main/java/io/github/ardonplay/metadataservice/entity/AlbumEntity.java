package io.github.ardonplay.metadataservice.entity;

import io.github.ardonplay.metadataservice.util.AlbumType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "albums")
@Data
public class AlbumEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue
  private UUID id;

  @Enumerated(EnumType.STRING)
  private AlbumType type;

  @Column(name = "title")
  private String title;

  @Column(name = "release_date")
  private Date releaseDate;

  @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
  private Set<MusicTrackEntity> tracks = new HashSet<>();

  @ManyToOne(fetch = FetchType.LAZY)
  private ArtistEntity artist;

  @ManyToOne(fetch = FetchType.LAZY)
  private GenreEntity genre;

}
