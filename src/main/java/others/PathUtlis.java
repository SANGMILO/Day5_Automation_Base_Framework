package others;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class  PathUtlis {
    private PathUtlis() {}

    /** 🔹 Thư mục gốc project */
    public static Path projectRoot() {
        return Paths.get(System.getProperty("user.dir")).toAbsolutePath();
    }

    /** 🔹 src/test/resources */
    public static Path testResources() {
        return projectRoot().resolve("src").resolve("test").resolve("resources");
    }

    /** 🔹 src/test/resources/environments */
    public static Path envDir() {
        return testResources().resolve("environments");
    }

    /** 🔹 Trả về đường dẫn file môi trường (VD: uat.properties, sit.properties...) */
    public static Path envFile(String envName) {
        String fileName = envName.endsWith(".properties") ? envName : envName + ".properties";
        return envDir().resolve(fileName);
    }

    /** 🔹 src/test/resources/datas */
    public static Path testDataDir() {
        return testResources().resolve("datas");
    }

    /** 🔹 Lấy file test data (VD: user.xlsx) */
    public static Path testData(String fileName) {
        return testDataDir().resolve(fileName);
    }

    /** 🔹 Thư mục downloads ở project root */
    public static Path downloadsDir() {
        Path dir = projectRoot().resolve("downloads");
        try {
            Files.createDirectories(dir);
        } catch (Exception e) {
            throw new RuntimeException("Không tạo được thư mục downloads!", e);
        }
        return dir;
    }
}
