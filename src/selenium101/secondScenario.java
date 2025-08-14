package selenium101;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class secondScenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();


	        try {
			driver.get("https://www.lambdatest.com/selenium-playground/");
			driver.manage().window().maximize();
			Thread.sleep(2000);

			  Thread.sleep(200); 
			WebElement DrageAndDroplink = driver.findElement(
					By.xpath("//a[@href='https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo']"));
			DrageAndDroplink.click();

			Thread.sleep(1000);
			WebElement slider3 = driver.findElement(By.xpath(".//*[@id='slider3']/div/input"));
			
			Thread.sleep(1000);
			Actions move = new Actions(driver);
			Actions action = (Actions) move.dragAndDropBy(slider3, 215, 0);
			action.perform();

			WebElement Expected_Range = driver.findElement(By.xpath(".//*[@id='slider3']/div/output"));
			String Expe_range = Expected_Range.getText();
			String Actual_Range = "95";

			if (Expe_range.contains(Actual_Range)) {
				System.out.println("Range is matched");
			} else {
				System.out.println("Range is not matched!");
			}
	        }catch (Exception e) {
	            System.out.println("Test failed due to exception: " + e.getMessage());
	        } finally {
	            driver.quit();
	        }
	}

}
