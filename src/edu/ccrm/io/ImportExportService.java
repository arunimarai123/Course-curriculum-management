package edu.ccrm.io;

import java.nio.file.Path;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;

public class ImportExportService {
    public static List<String> readAllLines(Path p) throws IOException {
        return Files.readAllLines(p);
    }
}
