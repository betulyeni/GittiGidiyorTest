package Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.Random;

public  class BaseTest {
    protected WebDriver webDriver;
    protected  Wait<WebDriver> bekle;

    private void setup(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("start-maximized");
        webDriver =new ChromeDriver(options);
        bekle = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }


    @Before
    public  void  beforeTest(){
        setup();
    }

   // @After
    public  void  afterTest(){
        webDriver.quit();
    }

    public void getPage(String url){
        webDriver.get(url);
    }

    public void click(WebElement element){
        try {
            element.click();
        }
        catch (Exception e){
            System.out.println(element.getText()+" elementine tiklanamadi.");
        }
    }

    public void write(WebElement element,String text){
        try {
            element.sendKeys(text);
        }
        catch (Exception e){
            System.out.println(element.getText()+" elementine deger gonderilemedi.");
        }
    }
    public void writeAndEnter(WebElement element,String text){
        try {
            element.sendKeys(text, Keys.ENTER);
        }
        catch (Exception e){
            System.out.println(element.getText()+" elementine deger gonderilemedi.");
        }
    }

    public String getElementText(WebElement element){
        return  element.getText();
    }

    public void randomSelectProduct(){
        waitSeconds(2);
        Random rand=new Random();
        int r = rand.nextInt(10);
        System.out.println(r);
        webDriver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[4]/div[2]/ul/li["+r+"]")).click();
        System.out.println("Ürün seçildi");


    }

    public void waitForPageLoad(By by) {
        bekle.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitElementToClickable(By by) {
        try {
            bekle.until(ExpectedConditions.elementToBeClickable(by));
        }
        catch(TimeoutException e){
            System.out.println(e);
        }
    }


    protected void waitSeconds(int seconds) {
        try {
            System.out.println(seconds + " saniye kadar bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    public void clickWithEnter(WebElement element){
        try {
            element.sendKeys(Keys.ENTER);
        }
        catch (Exception e){
            System.out.println(element.getText()+" elementine tiklanamadi.");
        }
    }

    public void clickWithById(By by){
        try {
            WebElement element= webDriver.findElement(by);
            element.click();
        }
        catch (Exception e){
            System.out.println(" elementine tiklanamadi.");
        }
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            webDriver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


}
