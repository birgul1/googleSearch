package GoogleSearch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class googleSearch {
    /*
         Senaryo: Google'da Arama Yapma
    Tarayıcıyı başlat.
    Google'ı ziyaret et.
    Arama kutusuna "Selenium otomasyon" yaz.
    Arama sonuçları sayfasını kontrol et ve başlıklardan birini aç.
    Açılan sayfanın başlığını kontrol et.
    Tarayıcıyı kapat.*/
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void Test() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchBox.sendKeys("Selenium otomasyon");
        searchBox.sendKeys(Keys.RETURN);

        Thread.sleep(2000);

        WebElement firstResult = driver.findElement(By.xpath("(//*[@class='cHaqb'])[1] "));
        firstResult.click();

        System.out.println(driver.getTitle());
    }
    @After
    public void tearDown(){
        driver.quit();

    }
}
