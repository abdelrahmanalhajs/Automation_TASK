import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class RegisterationTest {



    public static WebDriver driver;
    String Chromepath=System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
    Dimension dimension = new Dimension(1024, 768);


    String fname= LoadProperties.userData.getProperty("Firstname");
    String lname= LoadProperties.userData.getProperty("Lastname");
    String email= LoadProperties.userData.getProperty("Email");
    String pw= LoadProperties.userData.getProperty("Password");
    String address= LoadProperties.userData.getProperty("Address");
    String city= LoadProperties.userData.getProperty("City");
    String state= LoadProperties.userData.getProperty("State");
    String zip= LoadProperties.userData.getProperty("ZipCode");
    String mobile= LoadProperties.userData.getProperty("MobileNumber");


    @BeforeMethod
    public void setup()
    {

        System.setProperty("webdriver.chrome.driver", Chromepath);
        driver = new ChromeDriver();
        driver.manage().window().setSize(dimension);
        driver.navigate().to("http://automationpractice.com/index.php");



    }

    @Test
    public void SignupTest()
    {
        WebElement signInBtn= driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
        signInBtn.click();

        WebElement Email=driver.findElement(By.id("email_create"));
        Email.sendKeys(email);

        WebElement create=driver.findElement(By.id("SubmitCreate"));
        create.click();

        String loginPageTitle=driver.getTitle();
        System.out.println(loginPageTitle);

        Assert.assertTrue(loginPageTitle.contains("Login"));


        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMinutes(1));


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='customer_firstname']")));

        WebElement FName=driver.findElement(By.xpath("//input[@id='customer_firstname']"));

        WebElement LName=driver.findElement(By.xpath("//input[@id='customer_lastname']"));

        WebElement PW=driver.findElement(By.xpath("//input[@id='passwd']"));

        WebElement Address=driver.findElement(By.xpath("//input[@id='address1']"));

        WebElement City=driver.findElement(By.xpath("//input[@id='city']"));

        Select statDropDown= new Select(driver.findElement(By.id("id_state")));

        WebElement ZipCode= driver.findElement(By.xpath("//input[@id='postcode']"));


        WebElement MobileNumber=driver.findElement(By.xpath("//input[@id='phone_mobile']"));

        WebElement RegisterBtn=driver.findElement(By.xpath("//button[@id='submitAccount']/span"));


        FName.sendKeys(fname);
        LName.sendKeys(lname);
        PW.sendKeys(pw);
        Address.sendKeys(address);
        City.sendKeys(address);
        statDropDown.selectByVisibleText(state);
        ZipCode.sendKeys(zip);
        MobileNumber.sendKeys(mobile);
        RegisterBtn.click();


        String RegisterTitle=driver.getTitle();
        System.out.println(RegisterTitle);
        Assert.assertTrue(RegisterTitle.contains("My account"));



    }




    @Test
    public void authentication()
    {

        WebElement signInBtn= driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
        signInBtn.click();

        WebElement Email=driver.findElement(By.id("email_create"));
        Email.sendKeys(email);

        WebElement create=driver.findElement(By.id("SubmitCreate"));
        create.click();


        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("create_account_error"))));

        WebElement warning=driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li"));
        String warningMsg=warning.getText();
        System.out.println(warningMsg);

        Assert.assertTrue(warningMsg.contains("or request a new one"));

    }


   /* @AfterMethod
    public void end()
    {
        driver.quit();
    } */

}
