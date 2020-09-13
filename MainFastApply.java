package production.Staging;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainFastApply {
	
	public static WebDriver driver;
	static PageSRAFA PageSRAFA;
	
	@BeforeClass
	public static void Before() throws SQLException{
		Staging.DbConnection.DbAccess("rminta14.redmatch.net\\SQLSTAGING","sa", "Newspaper!");
		Staging.DbConnection.DbUpdate("util_deletecandidate'886288810@noemail.lan.lan', 512650");
		driver = new FirefoxDriver();
		driver.manage().window().maximize() ;
		// switch between staging and production BEGIN
		
		driver.navigate().to("http://staginginta.redmatch.com/Staging_RecruiterPro/candidate/search/publicsearchresults.aspx?AffiliateId=512650");
		//driver.navigate().to("http://career.tnuva.co.il/Search/publicsearchresults.aspx");
		// switch between staging and production END
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PageSRAFA = PageFactory.initElements(driver, PageSRAFA.class);}
	
	@Test
	public  void test_1() throws InterruptedException {
	/// page search results
	driver.findElement(By.xpath("//a[@id='ctl00_MasterContentPlaceHolder_SearchResults1_gvMatchListJobs_ctl02_lnkApply']")).click();
	/// page SRAFA
	PageSRAFA.FirstName.sendKeys("שם פרטי");
	PageSRAFA.LastName.sendKeys("שם משפחה");
	PageSRAFA.email.sendKeys("autotest1@redmatch.com");
	PageSRAFA.IdNo.sendKeys("886288810");
	PageSRAFA.CellPhone.sendKeys("0505214141");
	PageSRAFA.region.click();
	PageSRAFA.UploadResume.sendKeys("C:\\Users\\akeren\\Desktop\\Resumes\\adam.doc");
	
	Select dropdown = new Select(PageSRAFA.CandidateSourcesTypeDropDown);
	dropdown.selectByVisibleText("אחר");
	PageSRAFA.CandidateSourcesFreeText.sendKeys("other");
	PageSRAFA.signinbutton.click();
	}
	@org.junit.After
	public void  After(){
		driver.quit();
	}
	
	
	 
	
//	Select dropdown = new Select(driver.findElement(By.id("ctl00_MasterContentPlaceHolder_CandidatesSources_CandidateSourcesTypeDropDown")));
//	dropdown.selectByVisibleText("אחר");
//	driver.findElement(By.xpath("//input[@id='ctl00_MasterContentPlaceHolder_CandidatesSources_FreeTextSource']")).sendKeys("other");
//	driver.findElement(By.xpath("//a[@id='ctl00_MasterContentPlaceHolder_ltrSignNowForFree']")).click();
	
	
	
	
	}




//select * from personnel where idno = '886288810'
//util_deletecandidate'886288810@noemail.lan.lan', 512650