package io.github.ardonplay.metadataservice.entity;

import io.github.ardonplay.metadataservice.util.AlbumType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "albums")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
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

  @ManyToMany(mappedBy = "albums", fetch = FetchType.LAZY)
  private Set<TrackEntity> tracks = new HashSet<>();

  @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
  @JoinTable(
      name = "album_artist",
      joinColumns = { @JoinColumn(name = "album_id") },
      inverseJoinColumns = { @JoinColumn(name = "artist_id") }
  )
  private Set<ArtistEntity> artists = new HashSet<>();

  @ManyToOne(fetch = FetchType.LAZY)
  private GenreEntity genre;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlbumEntity that = (AlbumEntity) o;
    return Objects.equals(id, that.id) && type == that.type && Objects.equals(
        title, that.title) && Objects.equals(releaseDate, that.releaseDate)
        && Objects.equals(genre, that.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, title, releaseDate, genre);
  }
}
