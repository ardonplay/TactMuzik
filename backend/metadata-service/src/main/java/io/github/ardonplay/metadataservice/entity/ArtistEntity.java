package io.github.ardonplay.metadataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "artists")
@Data
public class ArtistEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue
  private UUID id;

  private String name;

  @ManyToOne
  private GenreEntity genre;

  @OneToMany(mappedBy = "artist")
  private Set<MusicTrackEntity> tracks = new HashSet<>();

  @OneToMany(mappedBy = "artist")
  private Set<AlbumEntity> albums = new HashSet<>();

}
