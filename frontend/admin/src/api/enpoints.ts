import { config } from "@/appConfig"
import buildUrl from "build-url-ts"

const { host, https} = config


const metadataHost = (https ? 'https' : 'http') + '://' + host.metadata
const streamingHost = (https ? 'https' : 'http') + '://' + host.streaming
const uploaderHost= (https ? 'https' : 'http') + '://' + host.uploader


export type FindByTitleParams = {
    page?: number
    limit?: number
    query: string
}

export type FindByDateParams = {
    page?: number
    limit?: number
    order?: 'asc' | 'desc'
}

export type FindById = {
    id: string | number
}

export type FindByUuid = {
    uuid: string
}


export const api = {
    urlForTrackMetadataUpload: () => metadataHost + '/api/v1/metadata/track/new',
    urlForSingleUpload: () => uploaderHost + '/api/v1/upload',
}
