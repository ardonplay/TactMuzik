package io.github.ardonplay.tactmuzik.uploadservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadDataDtoOut {
    private String trackId;
    private String coverId;
}
