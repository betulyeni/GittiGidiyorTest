package PageObject;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeObjects {
    @FindBy(how = How.CSS,using = "#header_wrapper > div.header-icon-container.robot-header-iconContainer.gg-w-5.gg-d-6.gg-t-14.gg-m-11.gg-w-push-14.gg-d-push-12.gg-t-push-0.gg-m-push-0 > div.profile-container.robot-header-iconContainer-profile > a > div.profile-icon-title > div > span.profile-name")
    public  WebElement toLoginPageElement;
    @FindBy(how = How.CLASS_NAME,using = "profile-name")
    public  WebElement profileName;
    @FindBy(how = How.XPATH,using = "//*[@id=\"__next\"]/header/div[3]/div/div[1]/div/div[2]/div/div[1]/div[2]/input")
    public  WebElement searhElement;
    @FindBy(how = How.CLASS_NAME,using = "search-result-keyword")
    public  WebElement resultSearchText;
    @FindBy(how = How.ID,using = "search_word")
    public  WebElement searhElement2;
    @FindBy(how = How.XPATH,using = "/html/body/div[5]/div[2]/div/div[2]/div[4]/div[2]/ul")
    public WebElement searchResultElements;
    @FindBy(how = How.CLASS_NAME,using = "clearfix")
    public WebElement searchResultMain;
    @FindBy(how = How.ID,using = "sp-price-lowPrice")
    public WebElement productActualPrice;
    @FindBy(how = How.ID,using = "add-to-basket")
    public WebElement addToBasket;
    @FindBy(how = How.CLASS_NAME,using = "guven-text")
    public WebElement copyRightText;
    @FindBy(how = How.CLASS_NAME,using = "dIB")
    public WebElement toBasketPage;



}
