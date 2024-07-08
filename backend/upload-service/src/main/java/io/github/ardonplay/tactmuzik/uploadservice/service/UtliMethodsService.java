package io.github.ardonplay.tactmuzik.uploadservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UtliMethodsService {

    public static boolean isFileAudio(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && (
                contentType.equals("audio/mpeg") ||
                        contentType.equals("audio/flac") ||
                        contentType.equals("audio/wav") ||
                        contentType.equals("audio/ogg"));
    }

    public static String calculateMD5(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        try (InputStream is = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = is.read(buffer)) != -1) {
                digest.update(buffer, 0, read);
            }
        }
        byte[] md5Bytes = digest.digest();
        return Base64.getUrlEncoder().withoutPadding().encodeToString(md5Bytes);
    }

    public static String calculateMD5(byte[] data) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("MD5");

        try (InputStream is = new ByteArrayInputStream(data)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = is.read(buffer)) != -1) {
                digest.update(buffer, 0, read);
            }
        }
        byte[] md5Bytes = digest.digest();
        return Base64.getUrlEncoder().withoutPadding().encodeToString(md5Bytes);
    }
}
