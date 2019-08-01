package humanity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.SecureRandom;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Tests {

	public static WebDriver driver;

	public static final String URL_HOME = "https://osa1.humanity.com/app/";
	private static final Random RANDOM = new SecureRandom();
	public static final int STRING_LENGTH = 8;
	String firstname = generateString();
	String lastname = generateString();
	String emailID = firstname + "@example.com";
	String wrongEmailID1 = firstname + "example.com";
	String wrongEmailID2 = firstname + "@examplecom";
	String wrongEmailID3 = firstname + "@.com";
	String wrongEmailID4 =   "@example.com";
	String wrongEmailID5 = firstname + "@";
	String wrongEmailID6= firstname + "@example.";

	public static String generateString() {
    	String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
		String pw = "";
		for (int i = 0; i < STRING_LENGTH; i++) {
			int index = (int) (RANDOM.nextDouble() * letters.length());
			pw += letters.substring(index, index + 1);
		}
		return pw.substring(0, 1).toUpperCase() + pw.substring(1).toLowerCase();
	}
	
	protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

	@BeforeClass
	public static void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL_HOME);
		driver.findElement(By.id("email")).sendKeys("dimitrijescekic@gmail.com");
		driver.findElement(By.name("password")).sendKeys("osaosa");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	}
	
	@Test
	public void test1AddNewEmployeeEmptyFirstNamefield() {
		
		try {
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("act_primary")).click();
			driver.findElement(By.cssSelector("#_asl1")).sendKeys(lastname);
			driver.findElement(By.cssSelector("#_ase1")).sendKeys(emailID);
			driver.findElement(By.cssSelector("#_as_save_multiple")).click();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl().toString(),("https://osa1.humanity.com/app/staff/add/"));	
		} 
		catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}
	
	@Test
	public void test2AddNewEmployeeEmptyLastNameEmailfield() {

		try {
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("act_primary")).click();
			driver.findElement(By.cssSelector("#_asf1")).sendKeys(firstname);
			driver.findElement(By.cssSelector("#_as_save_multiple")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			List<WebElement> employee = driver.findElements(By.className("employeesList"));
			assert(employee.get(0).getText().toString().contains(firstname));
		} 
		catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}
	
	@Test
	public void test3AddNewEmployeeWrongEmail() {
		
		try {
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("act_primary")).click();
			driver.findElement(By.cssSelector("#_asf1")).sendKeys(firstname);
			driver.findElement(By.cssSelector("#_asl1")).sendKeys(lastname);
			driver.findElement(By.cssSelector("#_ase1")).sendKeys(wrongEmailID1);
			driver.findElement(By.cssSelector("#_as_save_multiple")).click();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl().toString(),("https://osa1.humanity.com/app/staff/add/"));	
		} 
		catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}
	@Test
	public void test4AddNewEmployeeWrongEmail() {
		
		try {
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("act_primary")).click();
			driver.findElement(By.cssSelector("#_asf1")).sendKeys(firstname);
			driver.findElement(By.cssSelector("#_asl1")).sendKeys(lastname);
			driver.findElement(By.cssSelector("#_ase1")).sendKeys(wrongEmailID2);
			driver.findElement(By.cssSelector("#_as_save_multiple")).click();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl().toString(),("https://osa1.humanity.com/app/staff/add/"));	
		} 
		catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void test5AddNewEmployeeWrongEmail() {
		
		try {
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("act_primary")).click();
			driver.findElement(By.cssSelector("#_asf1")).sendKeys(firstname);
			driver.findElement(By.cssSelector("#_asl1")).sendKeys(lastname);
			driver.findElement(By.cssSelector("#_ase1")).sendKeys(wrongEmailID3);
			driver.findElement(By.cssSelector("#_as_save_multiple")).click();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl().toString(),("https://osa1.humanity.com/app/staff/add/"));	
		} 
		catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}
	
	@Test
	public void test6AddNewEmployeeWrongEmail() {
		
		try {
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("act_primary")).click();
			driver.findElement(By.cssSelector("#_asf1")).sendKeys(firstname);
			driver.findElement(By.cssSelector("#_asl1")).sendKeys(lastname);
			driver.findElement(By.cssSelector("#_ase1")).sendKeys(wrongEmailID4);
			driver.findElement(By.cssSelector("#_as_save_multiple")).click();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl().toString(),("https://osa1.humanity.com/app/staff/add/"));	
		} 
		catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void test7AddNewEmployeeWrongEmail() {
		
		try {
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("act_primary")).click();
			driver.findElement(By.cssSelector("#_asf1")).sendKeys(firstname);
			driver.findElement(By.cssSelector("#_asl1")).sendKeys(lastname);
			driver.findElement(By.cssSelector("#_ase1")).sendKeys(wrongEmailID5);
			driver.findElement(By.cssSelector("#_as_save_multiple")).click();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl().toString(),("https://osa1.humanity.com/app/staff/add/"));
		} 
		catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void test8AddNewEmployeeWrongEmail() {
		
		try {
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("act_primary")).click();
			driver.findElement(By.cssSelector("#_asf1")).sendKeys(firstname);
			driver.findElement(By.cssSelector("#_asl1")).sendKeys(lastname);
			driver.findElement(By.cssSelector("#_ase1")).sendKeys(wrongEmailID6);
			driver.findElement(By.cssSelector("#_as_save_multiple")).click();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl().toString(),("https://osa1.humanity.com/app/staff/add/"));	
		} 
		catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}


	@Test
	public void test9AddNewEmployee() {

		try {
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("act_primary")).click();
			driver.findElement(By.cssSelector("#_asf1")).sendKeys(firstname);
			driver.findElement(By.cssSelector("#_asl1")).sendKeys(lastname);
			driver.findElement(By.cssSelector("#_ase1")).sendKeys(emailID);
			driver.findElement(By.cssSelector("#_as_save_multiple")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='sn_staff']//span[@class='primNavQtip__inner']")).click();
			List<WebElement> employee = driver.findElements(By.className("employeesList"));
			assert(employee.get(0).getText().toString().contains(firstname));
		} 
		catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@Test
	public void testClockInOut() {
		try {
			driver.findElement(By.xpath("//i[@class='primNavQtip__icon icon-timeclock']")).click();
			assertTrue(isElementPresent(By.id("tc_tl_ci")));
			driver.findElement(By.id("tc_tl_ci")).click();
			assertTrue(isElementPresent(By.id("tc_tl_co")));
			driver.findElement(By.id("tc_tl_co")).click();
			assertTrue(isElementPresent(By.id("tc_tl_ci")));
		} catch (Exception e) {
			e.printStackTrace();
			assert false;
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		try {
			driver.findElement(By.cssSelector("#tr_avatar")).click();
			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("Sign O")).click();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}
