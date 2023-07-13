package app.service;

import app.utils.Constants;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteService {
    public String writeToFile(String fileName, String content) {
        Path path = Paths.get(Constants.BASE_PATH + fileName + ".txt");
        try {
            Files.writeString(path, content);
        } catch (FileAlreadyExistsException ex) {
        return "File already exists!";
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return "Recorded successfully in: " + path;
    }
}
