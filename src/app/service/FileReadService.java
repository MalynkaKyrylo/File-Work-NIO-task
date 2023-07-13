package app.service;

import app.utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadService {
    public String readFromFile(String fileName) {
        Path path = Paths.get(Constants.BASE_PATH + fileName + ".txt");
        try {
            return Files.readString(path);
        } catch (IOException ex) {
            return "Something wrong " + ex.getMessage();
        }
    }
}
