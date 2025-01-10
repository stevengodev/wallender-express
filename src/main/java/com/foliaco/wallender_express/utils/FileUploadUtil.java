package com.foliaco.wallender_express.utils;

import com.foliaco.wallender_express.exception.FileOperationException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

/**
 * Utility class for file operations such as saving, deleting, and ensuring directory existence.
 */
@Component
public class FileUploadUtil {

    private FileUploadUtil(){
    }

    /**
     * Ensures that a directory exists. If it does not exist, it creates the directory.
     *
     * @param directoryPath the path of the directory to check or create
     * @throws FileOperationException if an I/O error occurs while creating the directory
     */
    public static void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            try {
                Files.createDirectories(directory.toPath());
            } catch (IOException e) {
                throw new FileOperationException("Could not create directory");
            }
        }
    }

    /**
     * Saves a file to the specified directory with a unique name.
     *
     * @param directoryPath the directory where the file should be saved
     * @param file the file to save
     * @return the unique name of the saved file
     * @throws FileOperationException if the file is empty or if an I/O error occurs while saving the file
     */
    public static String saveFile(String directoryPath, MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileOperationException("No file selected");
        }

        String uniqueFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path targetLocation = Path.of(directoryPath).resolve(uniqueFileName);
        try {
            file.transferTo(targetLocation);
        } catch (IOException e) {
            throw new FileOperationException("Failed to create directory: " + directoryPath);
        }

        return uniqueFileName;
    }

    /**
     * Deletes a file from the specified directory.
     *
     * @param directoryPath the directory containing the file
     * @param fileName the name of the file to delete
     * @throws FileOperationException if an I/O error occurs while deleting the file
     */
    public static void deleteFile(String directoryPath, String fileName) {
        Path filePath = Path.of(directoryPath).resolve(fileName);
        if (filePath.toFile().exists()) {
            try {
                Files.delete(filePath);
            } catch (IOException e) {
                throw new FileOperationException("Failed to delete file: " + fileName);
            }
        }
    }

}
