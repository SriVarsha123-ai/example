package Docker;

import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Docker_Selenium {
    public static void main(String[] args) {
        try {
            // Set Firefox options
            FirefoxOptions options = new FirefoxOptions();

            // Connect to the Selenium Grid running in Docker
            URL url = new URL("http://localhost:4444/wd/hub");

            // Create RemoteWebDriver instance
            RemoteWebDriver driver = new RemoteWebDriver(url, options);

            // Open a website
            driver.get("https://www.google.com");

            // Print the page title
            System.out.println("Title: " + driver.getTitle());

            // Close the browser
            driver.quit();

        } catch (MalformedURLException e) {
            System.out.println("Invalid Selenium URL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
