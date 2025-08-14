package selenium101;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstScenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");

      
        WebDriver driver = new ChromeDriver();

        try {
          
            driver.get("https://www.lambdatest.com/selenium-playground");

            
            driver.findElement(By.linkText("Simple Form Demo")).click();

            
            if (!driver.getCurrentUrl().contains("simple-form-demo")) {
                System.out.println("URL is incorrect. Test failed.");
                return;
            }

           
            String testMessage = "Welcome to LambdaTest!";
            WebElement messageBox = driver.findElement(By.id("user-message"));
            messageBox.sendKeys(testMessage);

            
            driver.findElement(By.id("showInput")).click();
            

            
            WebElement displayed = driver.findElement(By.id("message"));
            String output = displayed.getText();

            if (output.equals(testMessage)) {
                System.out.println("✅ Test Passed: Message displayed correctly.");
            } else {
                System.out.println("❌ Test Failed: Message mismatch.");
            }

        } finally {
           
//            driver.quit();
        }
    }



}
