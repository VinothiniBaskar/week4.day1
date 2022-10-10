package week3.webtable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Launch the Browser
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Get the number of rows in the table by using XPath
		List<WebElement> noOfRows = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
        //Get the size of the row
		int rowSize = noOfRows.size();
		System.out.println("The Number of Rows in the Table is :" + rowSize);
		
		//Get the number of Columns in the table by using XPath
		List<WebElement> noOfColumns = driver.findElements(By.xpath("//table[@class='attributes-list']//tr//td"));
        //Get the size of the Columns
		int columnsSize = noOfColumns.size();
		System.out.println("The Number of Columns  in the Table is :" + columnsSize);
		
		//Get the data of fourth row of 3rd data
		WebElement data = driver.findElement(By.xpath("//table[@class='attributes-list']//tr[4]//td[3]"));
		//Get the text
		String text = data.getText();
		System.out.println("The forth row of third data is :"+text);
		
	}

}

