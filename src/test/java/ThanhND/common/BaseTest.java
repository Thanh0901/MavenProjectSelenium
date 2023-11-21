package ThanhND.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    //create browser
    public static void createDriver() {
        //set browser option
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        //set screen browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //close browser
    public static void closeDriver() {
        sleep(2);
        driver.close();
    }

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
