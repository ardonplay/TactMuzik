package io.github.ardonplay.metadataservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "genres")
@Data
public class GenreEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
  private Set<ArtistEntity> artists;

  @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
  private Set<MusicTrackEntity> tracks;

  @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
  private Set<AlbumEntity> albums;

}
