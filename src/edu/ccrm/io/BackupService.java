package edu.ccrm.io;

import edu.ccrm.config.AppConfig;
import java.nio.file.*;
import java.io.IOException;

public class BackupService {
    public static Path makeTimestampedBackup(Path sourceFile) throws IOException {
        Path dataDir = AppConfig.getInstance().getDataDir();
        Path backupDir = dataDir.resolve("backup-" + AppConfig.getInstance().timestamp());
        Files.createDirectories(backupDir);
        Path dest = backupDir.resolve(sourceFile.getFileName());
        return Files.copy(sourceFile, dest, StandardCopyOption.REPLACE_EXISTING);
    }
}
