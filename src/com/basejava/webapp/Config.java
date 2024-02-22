package com.basejava.webapp;

import com.basejava.webapp.storage.SqlStorage;
import com.basejava.webapp.storage.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final String HOME_DIR = "C:\\JavaCourse\\BaseJava";
    private static final File PROPS = new File(getHomeDir(),"config\\resume.properties");
    private static final Config INSTANCE = new Config();
    private final File storageDir;
    private final Storage storageResumes;

    public static Config get() {
        return INSTANCE;
    }

    private Config() {
        try (InputStream is = new FileInputStream(PROPS)) {
            Properties props = new Properties();
            props.load(is);
            storageDir = new File(props.getProperty("storage.dir"));
            storageResumes = new SqlStorage(props.getProperty("db.url"),
                    props.getProperty("db.user"), props.getProperty("db.password"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPS.getAbsolutePath());
        }
    }

    public File getStorageDir() {
        return storageDir;
    }

    public Storage getStorageResumes() {
        return storageResumes;
    }

    private static File getHomeDir() {
        String prop = System.getProperty("homeDir");
        File homeDir = new File(prop == null ? HOME_DIR : prop);
        if (!homeDir.isDirectory()) {
            throw new IllegalStateException(homeDir + " is not directory");
        }
        return homeDir;
    }
}
