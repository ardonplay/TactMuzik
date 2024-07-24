export interface Track {
  id: string
  title: string
  duration: number
  artists: MusicBand[]
  s3Path: string
  s3CoverPath: string
}

export interface MusicBand {
  id: string
  name: string
  genre: string
}

export interface MusicAlbum {
  id: string
  title: string
  type: string
  artists: MusicBand[]
  tracks?: Track[]
  releaseDate: number
}

export interface Playlist {
  uuid: string
  name: string
  tracks: Track[]
}

export type TrackUploadMetadata = {
  title: string
  duration: number
  artists: string[]
  albums: string[]
  genre: string,
  s3Path: string
  s3CoverPath: string
}



