import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestCase1 {
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
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");

        if(!driver.getTitle().equals("My Store")){
            System.out.println("The title is not the expected");
        }

        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com/");
        driver.navigate().back();

        if(!driver.getCurrentUrl().equals("http://opencart.abstracta.us/index.php?route=common/home")){
            System.out.println("The url is not the expected");
        }

        driver.close();
    }
}
