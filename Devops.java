package first;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class devops {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

        // Create a new Chrome browser instance
        WebDriver driver = new ChromeDriver();

        // Navigate to Google
        driver.get("https://www.google.com");

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Verify the title
        if (title.equals("Google")) {
            System.out.println("Title verification passed.");
        } else {
            System.out.println("Title verification failed.");
        }

        // Close the browser
        driver.quit();
    }
}
