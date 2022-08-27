import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class TestCase2 {
    public static void main(String[] args) throws IOException {

        InputStream file = new FileInputStream("resources/config.properties");
        Properties properties = new Properties();
        properties.load(file);

        System.setProperty(properties.getProperty("PROPERTY_CHROME"), properties.getProperty("PATH_CHROME"));
        WebDriver driver=new ChromeDriver();

        //System.setProperty(properties.getProperty("PROPERTY_FIRE"), properties.getProperty("PATH_FIRE"));
        //WebDriver driver=new FirefoxDriver();

        //System.setProperty(properties.getProperty("PROPERTY_EDGE"), properties.getProperty("PATH_EDGE"));
        //WebDriver driver=new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a")).click();
        //driver.findElement(By.cssSelector("#home-page-tabs > li:nth-child(2) > a")).click();
        driver.findElement(By.id("contact-link")).click();
        driver.navigate().back();
        List<WebElement> elements =driver.findElements(By.xpath("//*[contains(@class,'price product-price')]"));
        int total = elements.size();
        System.out.println("total elements: "+total);

        //getText() shows the visible text and getAttribute shows the hidden or visible text
        System.out.println("first element: "+elements.get(1).getAttribute("textContent").trim());
        System.out.println("last element: "+elements.get(total-1).getAttribute("textContent").trim());

        driver.close();

    }
}
