import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * https://www.toolsqa.com/selenium-tutorial/
 * https://www.bing.com
 * https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59
 *
 * TO RUN
 *
 * cd "file location of jar file"
 * java -cp BingRewardsBot.jar Bot
 */

public class Bot {

    public static void main(String[] args) throws InterruptedException {

        //launching chrome driver
        final String DRIVER_PATH = "file location of chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);

        //navigating to website
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com");
        sleep();

        //signing in to website
        WebElement signIn = driver.findElement(By.id("id_s"));
        signIn.click();
        sleep();
        WebElement username = driver.findElement((By.name("loginfmt")));
        username.clear();
        username.sendKeys("microsoft email");
        sleep();
        WebElement next = driver.findElement((By.id("idSIButton9")));
        next.click();
        WebElement password = driver.findElement(By.name("passwd"));
        password.sendKeys("microsoft password");
        sleep();
        WebElement submit = driver.findElement(By.id("idSIButton9"));
        submit.click();
        sleep();

        //making a web search
        String[] alphabet = {"a", "b", "c", "d","e", "f", "g","h","i","j","k",
                "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int letter = (int)( Math.random() * 25 + 1);
        String key = alphabet[letter];
        String search = alphabet[letter];
        for (int i = 0; i < 10; i++) {
            sleep();
            driver.findElement(By.name("q")).sendKeys(search);
            sleep();
            driver.findElement(By.name("go")).click();
            sleep();
            driver.navigate().back();
             search+= key;
        }
        sleep();
        driver.quit();
    }

    private static void sleep() throws InterruptedException {
        Thread.sleep(2000);
    }
}