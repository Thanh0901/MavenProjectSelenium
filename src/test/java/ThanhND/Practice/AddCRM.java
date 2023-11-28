package ThanhND.Practice;

import ThanhND.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class AddCRM extends BaseTest {
    //Login crm system
    public static void signinCRM() {
        driver.get("https://rise.fairsketch.com/signin");

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
        driver.findElement(By.xpath("//div[@id='page-content']//a[normalize-space()='Clients']")).click();
    }

    //Enter data on Add clients dialog
    public static void enterDataAddClient(String companyName) {
        sleep(1);
        driver.findElement(By.xpath("//a[normalize-space()='Add client']")).click();
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys(companyName);
        driver.findElement(By.xpath("//div[@id='s2id_created_by']")).click();
        sleep(1);
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("John Doe", Keys.ENTER
        );
        //fill address
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(" 85069 Russel Shore Apt. 190");
        //fill city
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Germany");
        //fill state
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Washington");
        //fill zip
        driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("700000");
        //fill country
        driver.findElement(By.xpath("//input[@id='country']")).sendKeys("Cocos (Keeling) Islands");
        //fill phone
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("123 56789");
        //fill website
        driver.findElement(By.id("website")).sendKeys("https://google.com");
        //fill vat number
        driver.findElement(By.id("vat_number")).sendKeys("0");
        //fill gst number
        driver.findElement(By.id("gst_number")).sendKeys("0");
        //fill group
        driver.findElement(By.xpath("//div[@id='s2id_group_ids']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Silver')]")).click();
        //fill label
        driver.findElement(By.xpath("//div[@id='s2id_client_labels']")).click();
        //    driver.findElement(By.xpath("//div[contains(text(),'Satisfied')]")).click();
        driver.findElement(By.xpath("//div[normalize-space()='Inactive']")).click();
        //save btn
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    //Search client
    public static void checkClient(String companyName) {
        sleep(2);
        driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(companyName);
        sleep(2);
        String nameClient = driver.findElement(By.xpath("//table[@id='client-table']//tbody//tr[1]//td[2]")).getText();
        System.out.println(nameClient);
    }

    public static void main(String[] args) {

        createDriver();
        signinCRM();
        openClientPage();
        enterDataAddClient("Thanh Sine");
        checkClient("Thanh Sine");
        closeDriver();

    }
}
