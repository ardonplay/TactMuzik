package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "artists")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class ArtistEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue
  @NonNull
  private UUID id;

  @NonNull
  private String name;

  @NonNull
  @ManyToOne(fetch = FetchType.LAZY)
  private GenreEntity genre;

  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "artists", fetch = FetchType.LAZY)
  private Set<TrackEntity> tracks = new HashSet<>();

  @ManyToMany(mappedBy = "artists")
  private Set<AlbumEntity> albums = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtistEntity that = (ArtistEntity) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name)
        && Objects.equals(genre, that.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, genre);
  }
}
