package Screenshot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot
{

	public static void main(String[] args) throws InterruptedException, IOException, AWTException
	{
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/");
		Thread.sleep(2000);
		driver.navigate().to("http://leafground.com/pages/checkbox.html");
		Thread.sleep(2000);

		//Select the languages that you know?
		WebElement Language1=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[1]"));
		Language1.click();
		Thread.sleep(2000);
		WebElement Language2=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[2]"));
		Language2.click();

		//Taking Screenshot using Takes Screenshot
		//		TakesScreenshot screenshot=(TakesScreenshot) driver;
		//		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		//		File destinationFile=new File("C:\\Users\\Jagan\\eclipse-workspace\\com.screenshot\\Screenshot.png");
		//		FileHandler.copy(srcFile, destinationFile);
		//		Thread.sleep(1000);
		//		driver.close();
		
		// *(OR)* Using Robot class to capture full image while taking screenshot
		Robot robot=new Robot();
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle=new Rectangle(screensize);
		BufferedImage src=robot.createScreenCapture(rectangle);
		File destinationFile=new File("C:\\Users\\Jagan\\eclipse-workspace\\com.screenshot\\Screenshot.png");
		ImageIO.write(src, "png", destinationFile);
		Thread.sleep(1000);
		driver.close();
	}



	}
