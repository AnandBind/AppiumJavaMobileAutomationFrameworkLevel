import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	// Step 3: Set Up Appium Capabilities
	// private-Restric access this variable to other class
	// static- ensures only one instance of threadLoca;<AndroidDriver> exist for
	// this class
	// ThreadLocal each thread needs its own seprate Android driver ? specialy for
	// parallel
	// final- variable cannot be changed after initialization.
	private static final ThreadLocal<UiAutomator2Options> options = new ThreadLocal<>();
	private static final ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<>();
	private static final ThreadLocal<IOSDriver> iosDriver = new ThreadLocal<>();

	public static void capabilitys() {

		String platform = System.getProperty("platform", "android").toLowerCase();
		// gegetProperty() is a built-in method in Java. It belongs to the
		// java.lang.System class.
		if (platform.equals("android")) {
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("AnandEmulator");
			options.setAutomationName("UiAutomator2");
			options.setApp("E:\\General-Store.apk");
			options.setCapability("appium:logLevel", "debug");
			try {
				androidDriver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/"), options));
				System.out.println("App Launched Successfully!");
			} catch (MalformedURLException e) {
				throw new RuntimeException("Invalid Appium URL", e);

			}

		} else if (platform.equals("ios")) {
			XCUITestOptions options = new XCUITestOptions();
			options.setDeviceName("iPhoen 12");
			options.setPlatformVersion("platformVersion");
			options.setApp("apk path in Phone");
			options.setAutomationName("XCUITest");
			try {
				iosDriver.set(new IOSDriver(new URL("http://127.0.0.1:4723/"), options));
			} catch (MalformedURLException e) {
				throw new RuntimeException("Invalid Appium URL", e);
			}
		} else {
			throw new IllegalArgumentException("Invalid platform name! Use 'android' or 'ios'.");
		}

	}
	
	public static AndroidDriver getAndroidDriver() {
		return androidDriver.get();
	}
	
	public static IOSDriver getIOSDriver() {
		return iosDriver.get();
	}
	
    public static WebElement waitForExpectedElement(final By by,int timeout) {
    	WebDriverWait wait=new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(timeout));
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(by) );
    }

	public static void tearDown(){
		getAndroidDriver().quit();
	}

}
