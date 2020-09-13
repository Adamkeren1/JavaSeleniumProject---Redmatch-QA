package production.Staging;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GlobalSearch {
	

	private WebDriver driver;
	//PAGE 2 - PageMatchBox
	
	@FindBy(how = How.XPATH, using = "//a[@id='ctl00_MasterContentPlaceHolder_SearchResults1_gvMatchListJobs_ctl02_lnkApply']")
	static WebElement GoToApplyButton;
	

	

	
	
	
	
	public GlobalSearch(WebDriver driver)
	{

	this.driver = driver;	
	}
}




