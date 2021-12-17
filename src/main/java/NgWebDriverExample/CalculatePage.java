package NgWebDriverExample;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatePage {
	
	WebDriver driver;
	JavascriptExecutor jsDriver;
	NgWebDriver ngWebDriver;
	
	public CalculatePage(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		jsDriver = (JavascriptExecutor)driver;
		ngWebDriver= new NgWebDriver(jsDriver);
		driver.get("http://localhost:3456/");
		ngWebDriver.waitForAngularRequestsToFinish();
		
	}
	
	ByAngularModel first = ByAngular.model("first");
	ByAngularModel second = ByAngular.model("second");
	ByAngularModel operator = ByAngular.model("operator");
	ByAngularButtonText goButton = ByAngular.buttonText("Go!");
	By result = By.className("ng-binding");
	
	public String doSum(String a , String b) {
		driver.findElement(first).clear();
		driver.findElement(first).sendKeys(a);
		
		driver.findElement(second).clear();
		driver.findElement(second).sendKeys(b);
		
		driver.findElement(operator).sendKeys("+");
		driver.findElement(goButton).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		System.out.println("Addition result is " +driver.findElement(result).getText());
		return driver.findElement(result).getText();
	}
	
	public String doSub(String a , String b) {
		driver.findElement(first).clear();
		driver.findElement(first).sendKeys(a);
		
		driver.findElement(second).clear();
		driver.findElement(second).sendKeys(b);
		
		driver.findElement(operator).sendKeys("-");
		driver.findElement(goButton).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		System.out.println("Substraction result is " +driver.findElement(result).getText());
		return driver.findElement(result).getText();
	}
	
	public String doDivision(String a , String b) {
		driver.findElement(first).clear();
		driver.findElement(first).sendKeys(a);
		
		driver.findElement(second).clear();
		driver.findElement(second).sendKeys(b);
		
		driver.findElement(operator).sendKeys("/");
		driver.findElement(goButton).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		System.out.println("Division result is " +driver.findElement(result).getText());
		return driver.findElement(result).getText();
	}
	
	
	

}
