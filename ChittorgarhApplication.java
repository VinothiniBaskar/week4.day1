package week3.webtable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorgarhApplication {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Launch the Browser
		driver.get("https://www.chittorgarh.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// click the stock market and NSE Bulk Deals by using XPath
		driver.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();

		// Get the securityNames by using XPath
		List<WebElement> securityNames = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr//td[3]"));
		// Get the size of the securityNames
		int size = securityNames.size();
		System.out.println("The size of the securityNames is :" + size);

		// Declare a list of type String
		List<String> data = new ArrayList<String>();

		// Iterate the items using for each loop
		for (WebElement eachNames : securityNames) {
			String text = eachNames.getText();
			data.add(text);
		}
		// Print the items
		System.out.println(data);

		// Declare a TreeSet
		Set<String> uniqueSecurityNames = new TreeSet<String>();

		// Iterate the items using for each loop
		for (WebElement unique : securityNames) {
			String text1 = unique.getText();
			uniqueSecurityNames.add(text1);
		}
		// Print the items
		System.out.println(uniqueSecurityNames);

		// Get the size of items without duplicates
		System.out.println("The size of the uniqueSecurityNames is :" + uniqueSecurityNames.size());
	}

}
