import com.sun.javafx.PlatformUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

   
   
    @Test
    public void shouldBeAbleToSearchForHotels() {
    	//you need to set the path of the chrome driver before launching the browser
        
        setDriverPath();
        WebDriver driver = new ChromeDriver();


        driver =new ChromeDriver();
       	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       	
       	//I made some changes  with to ur code .noe it was working fine


            driver.get("https://www.cleartrip.com/");
            WebElement hotelLink =driver.findElement(By.linkText("Hotels"));
            hotelLink.click();
            WebElement localityTextBox =driver.findElement(By.id("Tags"));

            localityTextBox.sendKeys("Indiranagar, Bangalore");
            WebElement travellerSelection =driver.findElement(By.id("travellersOnhome"));

            new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
            WebElement searchButton =driver.findElement(By.id("SearchHotelsButton"));
            searchButton.click();

            driver.quit();

        }
    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
