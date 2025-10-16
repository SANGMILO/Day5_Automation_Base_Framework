package actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    //download
    protected Path downloadDir;

    public Path getDownloadDir() {
        return downloadDir;
    }
    @BeforeMethod
    //
    public void setUP() throws Exception {
        //1 chuan bi thu muc download trong project
        downloadDir = Paths.get(System.getProperty("user.dir"),"downloads");
        Files.createDirectories(downloadDir);

        //2. chromeoptions: set download.default_directory
        ChromeOptions options = getChromeOptions();
        //NEN tat automation infobar / cho headless tuy nhu cau
        //options.addArguments("--disable-infobars");
        //options.addArguments("--start-maximized");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        // 3) Chỉ dùng explicit wait -> implicit = 0
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        // 4) Cho action trang UploadDownload lấy nhanh downloadDir
        System.setProperty("download.dir", downloadDir.toAbsolutePath().toString());

    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadDir.toAbsolutePath().toString());
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.director_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }


    //
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    @org.testng.annotations.Parameters({"holdAfterSeconds", "keepBrowserOpen"})
    public void tearDown()
    {  // đọc cấu hình từ VM options
        int holdSeconds = Integer.parseInt(System.getProperty("hold", "0")); // ví dụ -Dhold=10
        boolean keepOpen = Boolean.parseBoolean(System.getProperty("keepOpen", "false")); // -DkeepOpen=true

        if (holdSeconds > 0) {
            try { Thread.sleep(holdSeconds * 1000L); } catch (InterruptedException ignored) {}
        }

        if (keepOpen) {
            System.out.println("[BaseTest] keepOpen=true -> Nhấn ENTER để đóng trình duyệt…");
            try { System.in.read(); } catch (IOException ignored) {}
        }

        if (driver != null) driver.quit();
    }

    /** Dừng tạm ngay trong test khi cần quan sát */
    protected void pause(int seconds) {
        try { Thread.sleep(seconds * 1000L); } catch (InterruptedException ignored) {}
    }

}
