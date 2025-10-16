package testcases;

import actions.BaseTest;
import actions.HomePageAction;
import actions.elements.ElementsLeftMenuAction;
import actions.elements.UpLoadAndDownloadAction;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class DownloadCase extends BaseTest {
    //download
    @Test
    public void DownloadTest() throws InterruptedException {
        HomePageAction home = new HomePageAction(driver);
        ElementsLeftMenuAction menu = new ElementsLeftMenuAction(driver);
        UpLoadAndDownloadAction up = new UpLoadAndDownloadAction(driver, downloadDir);

        home.openHome();
        home.goToElementsModule();
        menu.OpenUpLoadAndDownload();

        up.clickDownLoad();

        // chờ file “sampleFile…” xuất hiện trong thư mục download
        Path file = up.waitForDownloadedWithPrefix("sampleFile", Duration.ofSeconds(20));
        Assert.assertTrue(Files.exists(file), "File chưa được tải về: " + file);
        System.out.println("File download tại: " + file.toAbsolutePath());

        // Mở thư mục chứa file (Windows)
        try {
            new ProcessBuilder("explorer.exe", "/select,", file.toString()).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
