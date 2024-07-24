"use client"
import { Howl, Howler } from 'howler';
export default function Player() {
    var sound = new Howl({
        src: ['http://localhost:9999/api/play/8ZiMjcvj2pBQAVtnJPFVRQ'],
        html5: true,
        preload: "metadata",
        format: "mp3"
    });

   

    sound.play();

    return <div><h1>{sound.}</h1></div>
}