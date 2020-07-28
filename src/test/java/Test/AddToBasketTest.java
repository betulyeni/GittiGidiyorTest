package Test;

import Utils.Constant;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import PageObject.HomeObjects;

public class AddToBasketTest extends BaseTest{
    @Test
    public void addToBasketTest()
    {
        HomeObjects ho = PageFactory.initElements(webDriver, HomeObjects.class);
        getPage(Constant.mainUrl);
        WebElement searchElement = (isElementPresent(By.xpath("/html/body/div[2]/header/div[3]/div/div[1]/div/div[2]/div/div[1]/div[2]/input"))) ? ho.searhElement : ho.searhElement2;
        click(searchElement);
        writeAndEnter(searchElement,Constant.searchText);
        waitForPageLoad(By.id("query-mapping-container"));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,1000)");
        waitSeconds(3);
        randomSelectProduct();
        waitSeconds(3);
        clickWithEnter(ho.addToBasket);
        waitSeconds(2);
        clickWithEnter(ho.toBasketPage);

    }
}
