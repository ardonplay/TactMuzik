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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
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

  @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH})
  @JoinTable(
      name = "album_track",
      joinColumns = @JoinColumn(name = "album_id"),
      inverseJoinColumns = @JoinColumn(name = "track_id")
  )
  private Set<TrackEntity> tracks = new HashSet<>();

  @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH})
  @JoinTable(
      name = "album_artist",
      joinColumns = {@JoinColumn(name = "album_id")},
      inverseJoinColumns = {@JoinColumn(name = "artist_id")}
  )
  private Set<ArtistEntity> artists = new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH})
  @JoinTable(
      name = "album_genre",
      joinColumns = {@JoinColumn(name = "album_id")},
      inverseJoinColumns = {@JoinColumn(name = "genre_id")}
  )
  private List<GenreEntity> genres;

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
        && Objects.equals(tracks, that.tracks) && Objects.equals(artists,
        that.artists) && Objects.equals(genres, that.genres);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, title, releaseDate, tracks, artists, genres);
  }
}
