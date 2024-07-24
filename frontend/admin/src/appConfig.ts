export const config = {
    https: process.env.HTTPS === 'enable',
    host: {
        metadata: process.env.METADATA_HOST ?? 'localhost:8080',
        streaming:  process.env.STREAMING_HOST ?? 'localhost:9999',
        uploader: process.env.UPLOADER_HOST ?? 'localhost:8090'
    }
}

export const CONSTANTS = {
    ENTITY_PER_PAGE: 20
}

console.log("API:\n", config)