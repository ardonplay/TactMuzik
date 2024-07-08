package io.github.ardonplay.tactmuzik.uploadservice.exception.file;

public class UnsupportedFileTypeException extends Exception{
    public UnsupportedFileTypeException(String file) {
        super("Unsupported file type: ".concat(file));
    }
}
