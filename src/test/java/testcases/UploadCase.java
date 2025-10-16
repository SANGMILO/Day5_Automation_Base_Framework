package testcases;

import actions.BaseTest;
import actions.HomePageAction;
import actions.elements.ElementsLeftMenuAction;
import actions.elements.UpLoadAndDownloadAction;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadCase extends BaseTest {
    //upload
    @Test
    public void UploadTest() throws InterruptedException {
        HomePageAction home = new HomePageAction(driver);
        ElementsLeftMenuAction menu = new ElementsLeftMenuAction(driver);
        Path file = Paths.get(System.getProperty("user.dir"), "src", "test", "java", "datas", "user.xlsx");
        System.out.println("File path: " + file);

        // Kiểm tra file tồn tại
        Assert.assertTrue(Files.exists(file), "Không tìm thấy file: " + file);

        UpLoadAndDownloadAction up = new UpLoadAndDownloadAction(driver, getDownloadDir());

        home.openHome();
        home.goToElementsModule();
        menu.OpenUpLoadAndDownload();
        up.upLoadFile(file);

        // lấy kết quả hiển thị
        String result = up.upLoadResultText(); // đọc id uploadedFilePath
        Assert.assertTrue(result.toLowerCase().endsWith(file.getFileName().toString().toLowerCase()),
                "Upload result không khớp tên file. Thấy: " + result);

        // giữ lại trình duyệt 10s để xem kết quả
        Thread.sleep(10000);
    }
}
