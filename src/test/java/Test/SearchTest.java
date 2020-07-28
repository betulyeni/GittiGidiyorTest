package Test;

import Utils.Constant;
import Utils.ExpectedValues;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import PageObject.HomeObjects;

public class SearchTest extends BaseTest{
    @Test
    public  void  SearchPageTest() throws InterruptedException {
        HomeObjects ho = PageFactory.initElements(webDriver, HomeObjects.class);
        getPage(Constant.mainUrl);
        Thread.sleep(5000);
        click(ho.searhElement);
        Thread.sleep(2000);
        writeAndEnter(ho.searhElement,Constant.searchText);
        Assert.assertEquals(ExpectedValues.expectedSearchText,getElementText(ho.resultSearchText));
    }
}
