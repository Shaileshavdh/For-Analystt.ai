package module_8;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException, AWTException {
//		Module-8
//		Module 8_Selenium_framWorks,Synchronization
//		*******************************************

//		Assignment-2
//
//		Test Scenario I:  File Upload
//		Step-1 Launch Chrome Browser
		WebDriver cdriver= new ChromeDriver();
//		Step-2 Open Test URL https://smallpdf.com/word-to-pdf
		cdriver.get("https://smallpdf.com/word-to-pdf");
		cdriver.manage().window().maximize();
//		Step-3 Click on ChooseFile Button
		cdriver.findElement(By.xpath("//span[text()='Choose Files']")).click();
		Thread.sleep(2000);
//		Step-4 Automate Window Alert by Uploading File  Downloads
		StringSelection loc = new StringSelection("C:\\Users\\91720\\Downloads\\new 1.docx"); //PLs change the file location as per requirement.
		// Using string file location to load it in clipboard
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(loc,null);
				Robot rob =new Robot();
				// Using keyboard to paste i.e. Ctrl+V
						
						rob.keyPress(KeyEvent.VK_CONTROL);
						rob.keyPress(KeyEvent.VK_V);
						Thread.sleep(2000);
						rob.keyRelease(KeyEvent.VK_V);
						rob.keyRelease(KeyEvent.VK_CONTROL);
						Thread.sleep(2000);
						
				// Using keyboard to press Enter
						
						rob.keyPress(KeyEvent.VK_ENTER);
						rob.keyRelease(KeyEvent.VK_ENTER);
						
//		Step-5 Specify implicit Wait to Complete file Conversion and Download button get's displayed
		WebElement DownLoadButton = new WebDriverWait(cdriver,Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Download']")));
		
//		Step-6 Click on Download Button
		DownLoadButton.click();
		Thread.sleep(8000);
//		Step-5 Close Browser
		cdriver.close();	
				

	}

}
