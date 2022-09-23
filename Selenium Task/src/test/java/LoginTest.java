import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {


    public static WebDriver driver;
    String Chromepath=System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
    Dimension dimension = new Dimension(1024, 768);


    String email= LoadProperties.userData.getProperty("Email");
    String pw= LoadProperties.userData.getProperty("Password");



    @BeforeMethod
    public void setup()
    {

        System.setProperty("webdriver.chrome.driver", Chromepath);
        driver = new ChromeDriver();
        driver.manage().window().setSize(dimension);
        driver.navigate().to("http://automationpractice.com/index.php");



    }


    @Test
    public void Login()
    {



        WebElement signInBtn= driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
        signInBtn.click();

        WebElement Email=driver.findElement(By.id("email"));
        Email.sendKeys(email);


        WebElement PW=driver.findElement(By.id("passwd"));
        PW.sendKeys(pw);

        WebElement login=driver.findElement(By.id("SubmitLogin"));
        login.click();


    }

   /* @AfterMethod
    public void end()
    {
        driver.quit();
    } */
}
