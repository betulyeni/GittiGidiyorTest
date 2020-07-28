package Test;

import Utils.Constant;
import Utils.ExpectedValues;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import PageObject.HomeObjects;
import PageObject.LoginObjects;


public class LoginTest extends BaseTest{
    @Test
    public void Test() throws InterruptedException {
        HomeObjects ho = PageFactory.initElements(webDriver, HomeObjects.class);
        LoginObjects lo=PageFactory.initElements(webDriver,LoginObjects.class);
        getPage(Constant.mainUrl);
        waitElementToClickable(By.className("style__HeaderActionButton-sc-181qrxr-6 jeuMzl"));
        click(ho.toLoginPageElement);
        Thread.sleep(2000);
        write(lo.inputUserName, Constant.userName);
        write(lo.inputPassword,Constant.password);
        click(lo.loginButton);
        Thread.sleep(2000);
        Assert.assertEquals(getElementText(ho.profileName), ExpectedValues.expectedAccountName);
    }
}
