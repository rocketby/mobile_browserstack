package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Project;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL(Project.config.browserstack_url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", Project.config.username());
        desiredCapabilities.setCapability("browserstack.key", Project.config.password());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", Project.config.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", Project.config.device());
        desiredCapabilities.setCapability("os_version", Project.config.os_version());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "Wiki Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "wiki_test");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
