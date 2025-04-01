import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;


import io.appium.java_client.android.AndroidDriver;

public class verifyToastMessage extends BaseClass {
	
	public static void main(String [] args) throws MalformedURLException, InterruptedException {
		
		capabilitys();
		getAndroidDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		waitForExpectedElement(By.id("com.androidsample.generalstore:id/btnLetsShop"),10).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// validation message by assertions
		//String acutualMassage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		//Assert.assertEquals(acutualMassage, "Please enter your name", "Text mismatch!");
	}

}
