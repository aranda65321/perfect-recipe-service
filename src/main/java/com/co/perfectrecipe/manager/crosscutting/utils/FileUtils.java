package com.co.perfectrecipe.manager.crosscutting.utils;

import com.co.perfectrecipe.manager.crosscutting.domain.enums.TypeError;
import com.co.perfectrecipe.manager.crosscutting.exception.ApiProcessException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class FileUtils {
    public static String saveFile(String filePath, byte[] content) throws ApiProcessException {
        try {
            Path path = Paths.get(filePath);
            Path parentDir = path.getParent();
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }
            Files.write(path, content);
            System.out.println("Archivo guardado en: " + path.toAbsolutePath());
            return filePath;
        } catch (IOException e) {
            throw new ApiProcessException(e, TypeError.IR_023);
        }
    }

    public static String deleteFile(String filePath, byte[] content) throws ApiProcessException {
        try {
            Path path = Paths.get(filePath);
            Path parentDir = path.getParent();
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }
            Files.write(path, content);
            System.out.println("Archivo guardado en: " + path.toAbsolutePath());
            return filePath;
        } catch (IOException e) {
            throw new ApiProcessException(e, TypeError.IR_023);
        }
    }

    public static String encodeImageToBase64DataUrl(String imagePath, String mimeType) {
        String image = "";
        try {
            if (imagePath != null && !imagePath.isEmpty()) {
                File file = new File(imagePath);
                byte[] imageBytes = Files.readAllBytes(file.toPath());
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                return "data:" + mimeType + ";base64," + base64;
            }
        } catch (IOException e) {
            image = "";
        }
        return image;
    }
}
