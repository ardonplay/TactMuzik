package io.github.ardonplay.tactmuzik.uploader.shared.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UtilMethodsService {

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
