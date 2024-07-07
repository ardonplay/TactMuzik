package io.github.ardonplay.tactmuzik.uploadservice.service;


import lombok.RequiredArgsConstructor;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UploadService {

    private final ParseService parseService;

    public void upload(MultipartFile file) {
        try {
            Metadata metadata= parseService.parse(file);
            var names = metadata.names();
            //TODO add logic to upload and export interesting metadata to metadata service
        } catch (TikaException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

}
