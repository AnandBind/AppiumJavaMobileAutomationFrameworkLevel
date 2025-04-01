import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class scenario1PassText extends BaseClass  {
	
	public static void main(String [] args) throws MalformedURLException, InterruptedException {
		
		// to launch app in the emulator / device
		capabilitys();

		// start writing scenarion
		
		getAndroidDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		waitForExpectedElement(By.id("com.androidsample.generalstore:id/spinnerCountry"),10).click();
		getAndroidDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> list = getAndroidDriver().findElements(By.id("android:id/text1"));
		for(WebElement ele:list) {
			if(ele.getText().equals("Australia"))
			Thread.sleep(3000);
			ele.click();
			break;
		}
		getAndroidDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		waitForExpectedElement(By.id("com.androidsample.generalstore:id/nameField"),10).sendKeys("Anand");		
		waitForExpectedElement(By.id("com.androidsample.generalstore:id/btnLetsShop"),10).click();
	   
		// close the app
		tearDown();
	}

}
