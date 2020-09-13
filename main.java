package production.Staging;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Staging.PageLogin;

public class main {

	public static WebDriver driver;
	static PageLogin PageLogin;
	static PageMatchBox PageMatchBox;
	static CommonOps CommonOps;
	static GlobalSearch GlobalSearch;
	static PageApply staticPageApply;
	

	
	@BeforeClass
	public static void Before() throws SQLException{
		// Not reaveling any sensitive info of the company
		Staging.DbConnection.DbAccess("***","***", "***"); 
		Staging.DbConnection.DbUpdate("update *** set ***=0 where *** = 2183867");

		driver = new FirefoxDriver();

	
	CommonOps = PageFactory.initElements(driver, CommonOps.class);
	CommonOps.OpenBrowser("http://staginginta.redmatch.com/Staging_RecruiterPro/Candidate/Login/login.aspx?AffiliateId=51202");
	PageLogin = PageFactory.initElements(driver, PageLogin.class);
	
		//http://jobsil.redmatch.com/search/publicsearch.aspx?affiliateid=513006
	PageMatchBox = PageFactory.initElements(driver, PageMatchBox.class);
	GlobalSearch = PageFactory.initElements(driver, GlobalSearch.class);
	staticPageApply = PageFactory.initElements(driver, PageApply.class);
	
	}
		@Test
		public void test() throws InterruptedException{
			
			
		PageLogin.loginAction("***@***.com", "***");
			
			
		
				
				PageMatchBox.LinkToFindPositions.isDisplayed();
				PageMatchBox.LinkToLogOut.isDisplayed();
				PageMatchBox.LinkToProfile.isDisplayed();
				PageMatchBox.GoEditYourProfile.click();
				PageMatchBox.LinkToFindPositions.click();
				GlobalSearch.GoToApplyButton.click();
				Select ownershiptype = new Select(driver.findElement(By.id("ctl00_MasterContentPlaceHolder_CandidatesSources_CandidateSourcesTypeDropDown")));
				ownershiptype.selectByIndex(1);
				Thread.sleep(1000);
				driver.findElement(By.id("ctl00_MasterContentPlaceHolder_CandidatesSources_FreeTextSource")).sendKeys("test");
				driver.findElement(By.xpath("//a[@id='ctl00_MasterContentPlaceHolder_btnSubmit']")).click();
				Thread.sleep(3000);
				driver.quit();

		}

	
}
//this update must be made after the test for the next one to be valid
//
//update matches 
//set wishmatch=0
//where userid = 2183867
	


