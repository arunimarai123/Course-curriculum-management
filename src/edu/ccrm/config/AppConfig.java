package edu.ccrm.config;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

public final class AppConfig {
    private static AppConfig instance;
    private final Path dataDir;

    private AppConfig() {
        String userHome = System.getProperty("user.home");
        this.dataDir = Paths.get(userHome, "ccrm-data");
        try {
            if (!Files.exists(dataDir)) Files.createDirectories(dataDir);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create data dir: " + dataDir, e);
        }
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) instance = new AppConfig();
        return instance;
    }

    public Path getDataDir() {
        return dataDir;
    }

    public String timestamp() {
        return Instant.now().toString().replace(':','-');
    }
}
