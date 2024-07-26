package io.github.ardonplay.tactmuzik.uploader.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadDataOutDto {
    private String trackId;
    private String coverId;
}
