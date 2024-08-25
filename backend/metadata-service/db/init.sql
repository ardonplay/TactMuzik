CREATE TABLE Genres
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Artists
(
    id       uuid PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    genre_id INT,
    FOREIGN KEY (genre_id) REFERENCES Genres (id)
);

CREATE TABLE Albums
(
    id           uuid PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    type         VARCHAR(255) NOT NULL,
    genre_id     INT,
    release_date DATE,
    FOREIGN KEY (genre_id) REFERENCES Genres (id)
);

CREATE TABLE Tracks
(
    id            uuid PRIMARY KEY,
    title         VARCHAR(255) NOT NULL,
    genre_id      INT,
    duration      TIME,
    s3_path       varchar(255) NOT NULL,
    s3_cover_path varchar(255) NOT NULL,
    FOREIGN KEY (genre_id) REFERENCES Genres (id)
);

CREATE TABLE album_artist
(
    album_id  uuid NOT NULL,
    artist_id uuid NOT NULL,
    PRIMARY KEY (album_id, artist_id),
    FOREIGN KEY (album_id) REFERENCES Albums (id),
    FOREIGN KEY (artist_id) REFERENCES Artists (id)
);

CREATE TABLE album_track
(
    album_id uuid NOT NULL,
    track_id uuid NOT NULL,
    PRIMARY KEY (track_id, album_id),
    FOREIGN KEY (track_id) REFERENCES Tracks (id),
    FOREIGN KEY (album_id) REFERENCES Albums (id)
);

CREATE TABLE album_genre
(
    album_id uuid NOT NULL,
    genre_id INT  NOT NULL,
    PRIMARY KEY (album_id, genre_id),
    FOREIGN KEY (album_id) REFERENCES Albums (id),
    FOREIGN KEY (genre_id) REFERENCES Genres (id)
);