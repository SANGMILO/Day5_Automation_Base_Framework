public class GlobalVariables {
    public static Long EXPLICIT_WAIT = 15L;
    public static Long IMPLICIT_WAIT = 30L;

    // môi trường chung
    public static final String BASE_URL = "https://demoqa.com/";
    public static final String ENV_PROP_DIR = "src/test/resources/environments"; // nơi đặt *.properties
    public static final String DOWNLOAD_DIR = "downloads";                       // thư mục download mặc định

    public static final int TIMEOUT_SHORT = 5;
    public static final int TIMEOUT_MEDIUM = 10;
    public static final int TIMEOUT_LONG = 20;

    public static final String SYS_ENV = "env";           // -Denv=uat|sit|production
    public static final String SYS_HOLD = "hold";         // -Dhold=10
    public static final String SYS_KEEP_OPEN = "keepOpen";// -DkeepOpen=true
}
