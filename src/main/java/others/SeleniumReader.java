package others;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public final class SeleniumReader {
    private static final Properties PROPS = new Properties();

    private SeleniumReader() {}

    public static void loadEnv(String envName) throws IOException {
        Path file = others.PathUtlis.envFile(envName);
        try (FileInputStream fis = new FileInputStream(file.toFile())) {
            PROPS.clear();
            PROPS.load(fis);
        }
    }

    public static String get(String key) {
        return PROPS.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return PROPS.getProperty(key, defaultValue);
    }
}
