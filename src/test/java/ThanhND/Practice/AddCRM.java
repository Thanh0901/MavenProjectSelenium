package ThanhND.Practice;

import ThanhND.common.BaseTest;
import org.openqa.selenium.By;

public class AddCRM extends BaseTest {

    //Login crm system
    public static void signinCRM() {
        driver.get("https://rise.fairsketch.com/signin");
        sleep(1);

        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        sleep(1);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@demo.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("riseDemo");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
    }

    //Open Client Page
    public static void openClientPage() {
        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Clients')]")).click();
        //driver.findElement(By.xpath("//a[normalize-space()='Add client']")).click();
        System.out.println(2);
    }

    public static void main(String[] args) {

        createDriver();
        signinCRM();
        openClientPage();

        sleep(2);
        closeDriver();

    }
}
