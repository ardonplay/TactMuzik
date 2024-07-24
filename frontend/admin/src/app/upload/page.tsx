"use client"
import {useState, ChangeEvent, FormEvent} from 'react';
import {musicClient} from '@/api/client'
import {TrackUploadMetadata} from "@/api";

export default function Home() {
    const [title, setTitle] = useState<string>('');
    const [artist, setArtist] = useState<string>('');
    const [file, setFile] = useState<File | null>(null);

    const handleSubmit = async (event: FormEvent) => {
        event.preventDefault();
        const formData = new FormData();

        if (file) {
            formData.append('file', file);
        }

        const uploadTrackFileResponse = await musicClient.uploadTrack(formData);

        if (uploadTrackFileResponse.meta.status == 200) {

            const uploadTrackMetadata: TrackUploadMetadata = {
                duration: 540,
                albums: ['5Gsig7xrL1Eq25NehaW6Ur'],
                genre: 'ROCK',
                s3CoverPath: uploadTrackFileResponse.data.coverId,
                s3Path: uploadTrackFileResponse.data.trackId,
                title: title,
                artists: ['6PKcyrllvV37McNx6ycjVE']

            }
            musicClient.uploadTrackMetadata(uploadTrackMetadata).then(response => {
                alert(`Upload successful! response: ${JSON.stringify(response)}`);
            })



        } else {
            alert(`Upload failed! response: ${JSON.stringify(uploadTrackFileResponse)}`);
        }
    };

    return (
        <div>
            <h1>Upload Music Track</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>
                        Title:
                        <input
                            type="text"
                            value={title}
                            onChange={(e: ChangeEvent<HTMLInputElement>) => setTitle(e.target.value)}
                            required
                        />
                    </label>
                </div>
                <div>
                    <label>
                        Artist:
                        <input
                            type="text"
                            value={artist}
                            onChange={(e: ChangeEvent<HTMLInputElement>) => setArtist(e.target.value)}
                            required
                        />
                    </label>
                </div>
                <div>
                    <label>
                        File:
                        <input
                            type="file"
                            accept="audio/*"
                            onChange={(e: ChangeEvent<HTMLInputElement>) => {
                                if (e.target.files && e.target.files[0]) {
                                    setFile(e.target.files[0]);
                                }
                            }}
                            required
                        />
                    </label>
                </div>
                <button type="submit">Upload</button>
            </form>
        </div>
    );
}
