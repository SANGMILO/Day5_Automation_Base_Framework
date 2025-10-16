package actions.elements;

import actions.BasePage_Method_List;
import interfaces.elements.UpLoadDownloadInterFace;
import org.openqa.selenium.WebDriver;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UpLoadAndDownloadAction extends BasePage_Method_List implements UpLoadDownloadInterFace {

    private final Path downloadDir;

    public UpLoadAndDownloadAction(WebDriver driver, Path downloadDir) {
        super(driver);
        this.downloadDir = downloadDir;
    }

    // ========== DOWNLOAD ==========
    public void clickDownLoad() {
        // nếu trong BasePage_Method_List của bạn là "ScrollInToView" thì gọi đúng tên hàm của bạn
        scrollIntoView(DOWNLOAD_BTN);             // hoặc ScrollInToView(DOWNLOAD_BTN);
        waitForElementClickable(DOWNLOAD_BTN);
        // tránh bị che, dùng click JS là an toàn nhất ở màn này
        clickToElementByJS(DOWNLOAD_BTN);
    }

    /** Chờ file tải về theo tiền tố (VD: "sampleFile") */
    public Path waitForDownloadedWithPrefix(String prefix, Duration timeout) {
        long end = System.currentTimeMillis() + timeout.toMillis();
        while (System.currentTimeMillis() < end) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(downloadDir)) {
                for (Path path : stream) {
                    String name = path.getFileName().toString().toLowerCase();
                    if (name.startsWith(prefix.toLowerCase())
                            && !name.endsWith(".crdownload")
                            && !name.endsWith(".tmp")) {
                        return path;
                    }
                }
            } catch (Exception ignored) {
                // thư mục đang bận -> nghỉ 300ms rồi thử lại
            }
            sleep(Duration.ofMillis(300));
        }
        throw new RuntimeException("Không tìm thấy file tải về có prefix='" + prefix
                + "' trong " + timeout.getSeconds() + "s. Kiểm tra đúng downloadDir chưa?");
    }

    // ========== UPLOAD ==========
    public void upLoadFile(Path file) {
        if (file == null || !Files.exists(file)) {
            throw new IllegalArgumentException("File upload không tồn tại: " + file);
        }
        waitForElementIsVisible(UPLOAD_INPUT);
        // bắt buộc send đường dẫn tuyệt đối
        getElement(UPLOAD_INPUT).sendKeys(file.toAbsolutePath().toString());
        waitForElementIsVisible(UPLOAD_RESULT);
    }

    public String upLoadResultText() {
        waitForElementIsVisible(UPLOAD_RESULT);
        return getTextElement(UPLOAD_RESULT);
    }

    // ===== helper local =====
    private void sleep(Duration d) {
        try {
            TimeUnit.MILLISECONDS.sleep(d.toMillis());
        } catch (InterruptedException ignored) { }
    }
}
