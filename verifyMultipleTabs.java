package package1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class verifyMultipleTabs {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	
  @Test
  public void verifyMultiple() {
	  String mwindID =driver.getWindowHandle();
	  System.out.println("mwind:"+mwindID);
	  driver.findElement(By.xpath("//strong[text()='Signup']")).click();
	  Set<String>windIDS= driver.getWindowHandles();
	  System.out.println("wind:"+windIDS);
	  String childWind1=null;
	  for(String wind:windIDS) {
		  if(!wind.equals(mwindID)) {
			  childWind1=wind;
		  }
		  
	 }
	  driver.switchTo().window(childWind1);
	  driver.findElement(By.xpath("//input[@id='inputFirstName']")).sendKeys("saikumar");
	  driver.findElement(By.xpath("//input[@id='inputLastName']")).sendKeys("kumar");
	  driver.switchTo().window(mwindID);
	  driver.findElement(By.xpath("//li/a[text()='Demo']")).click();
	  driver.findElement(By.name("first_name")).sendKeys("rajesh");
	  driver.findElement(By.name("last_name")).sendKeys("reddy");
	  driver.findElement(By.xpath("//a/strong[text()='Login']")).click();
	  
	  
	  
	  windIDS=driver.getWindowHandles();
	  String childWind2=null;
	  for(String windID:windIDS) {
		  if(!windID.equals(mwindID)||  !windID.equals(childWind1)){
			  childWind2=windID;
			  
		  }
		  
	  }
	  driver.switchTo().window(childWind2);
	  driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys("saikumar003@gmail.com");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Saikumar751@");
	  driver.switchTo().window(childWind1);
	  driver.findElement(By.name("email")).sendKeys("sai751@gmail.com");
	  driver.findElement(By.xpath("//input[@name='phonenumber']")).sendKeys("98745612554");
	  driver.findElement(By.id("inputEmail")).click();
	  driver.findElement(By.id("inputEmail")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.id("inputEmail")).sendKeys(Keys.chord(Keys.CONTROL, "c"));
	  driver.findElement(By.id("inputCompanyName")).click();
	  driver.findElement(By.id("inputCompanyName")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
	  driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("esi hospital");

	  driver.quit();

	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new ChromeDriver();
	  driver.get("https://phptravels.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  action=new Actions(driver);
	  wait=new WebDriverWait(driver, Duration.ofSeconds(40));
	  
	  
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
