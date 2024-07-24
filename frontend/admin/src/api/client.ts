import { responseToPieApiResponse } from "./helper";
import {
  api, TrackUploadMetadata, Track
} from "./index";

export interface PieApiResponse<T> {
  data: T;
  meta: {
    status: number;
    xTotalCount: number;
  };
}

export interface TrackUploadResponse {
  trackId: string;
  coverId: string;
}


interface musicClient {
  uploadTrackMetadata:(body: TrackUploadMetadata) => Promise<PieApiResponse<Track>>;
  uploadTrack: (body: FormData) => Promise<PieApiResponse<TrackUploadResponse>>;

}

const get = () => {
  const headers = new Headers({
    "Content-Type": "application/json",
  });

  return {
    method: "GET",
    headers,
  };
};

const postWithBody = (
  params: {
    body?: any;
    contentType?: string;
    disableContentType?: boolean;
  },
) => {
  const headers = new Headers();

  if (!params.disableContentType) {
    if (params.contentType) {
      headers.append("Content-Type", params.contentType);
    } else {
      headers.append("Content-Type", "application/json");
    }
  }

  const body = params.body
    ? (params.disableContentType ? params.body : JSON.stringify(params.body))
    : undefined;

  console.log("payload: ", body);
  return {
    method: "POST",
    headers,
    body,
  };
};

export const musicClient: musicClient = {
  uploadTrack: async (body) =>
    fetch(
      api.urlForSingleUpload(),
      postWithBody({ body, disableContentType: true }),
    ).then(responseToPieApiResponse),

  uploadTrackMetadata: async (body) =>
      fetch(
          api.urlForTrackMetadataUpload(),
          postWithBody({ body }),
      ).then(responseToPieApiResponse),
};
