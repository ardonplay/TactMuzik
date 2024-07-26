package io.github.ardonplay.tactmuzik.metadata.spi.adapter.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Time;
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
@Table(name = "tracks")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class TrackEntity {

  @Id
  @GeneratedValue
  @NonNull
  private UUID id;

  @NonNull
  private String title;

  @NonNull
  private Time duration;

  @NonNull
  @Column(name = "s3_path")
  private String s3Path;

  @NonNull
  @Column(name = "s3_cover_path")
  private String s3CoverPath;

  @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
  @JoinTable(
      name = "track_album",
      joinColumns = { @JoinColumn(name = "track_id") },
      inverseJoinColumns = { @JoinColumn(name = "album_id") }
  )
  private Set<AlbumEntity> albums = new HashSet<>();

  @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
  @JoinTable(
      name = "track_artist",
      joinColumns = { @JoinColumn(name = "track_id") },
      inverseJoinColumns = { @JoinColumn(name = "artist_id") }
  )
  private Set<ArtistEntity> artists = new HashSet<>();

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private GenreEntity genre;

  @Override
  public String toString() {
    return "TrackEntity{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", duration=" + duration +
        ", s3Path='" + s3Path + '\'' +
        ", s3CoverPath='" + s3CoverPath + '\'' +
        ", albums=" + albums +
        ", artists=" + artists +
        ", genre=" + genre +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrackEntity that = (TrackEntity) o;
    return Objects.equals(id, that.id) && Objects.equals(title, that.title)
        && Objects.equals(duration, that.duration) && Objects.equals(s3Path,
        that.s3Path) && Objects.equals(s3CoverPath, that.s3CoverPath)
        && Objects.equals(albums, that.albums) && Objects.equals(artists,
        that.artists) && Objects.equals(genre, that.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, duration, s3Path, s3CoverPath, albums, artists, genre);
  }
}
