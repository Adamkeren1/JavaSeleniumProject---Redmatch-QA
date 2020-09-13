package production.Staging;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportConfiguration {
	
	@SuppressWarnings("deprecation")
	public static ExtentReports instance (){
        ExtentReports extent;
        String Path = "c:\\users\\akeren\\Desktop\\reporttest\\1.html";
        System.out.println(Path);
        extent = new ExtentReports (Path,true);
        extent.config()
        		.documentTitle("Automation Reoprts")
        		.reportName("Regression");
        return extent;
}
	
	public static String CaptureScreen (WebDriver driver,String ImagePath)
	{ 
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File ODest = new File(ImagePath+".jpg");
		try{FileUtils.copyFile(oScnShot,ODest);
			}
		catch (IOException e)
		{System.out.println(e.getMessage());
		}
		return ImagePath+".jpg";
	}
	}
   


