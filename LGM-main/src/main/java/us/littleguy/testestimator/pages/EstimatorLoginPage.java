package us.littleguy.testestimator.pages;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstimatorLoginPage extends BasePageObject  {

	
			private String pageUrl = "https://testestimator.littleguys.us/login";
			private By usernameLocator = By.id("exampleInputEmail1");
			private By passwordLocator = By.id("exampleInputPassword1");
			private By Getcaptcha = By.id("generated-captcha");
			private By EnterCaptcha = By.id("entered-captcha");
			private By logInButtonLocator = By.cssSelector("button[title='Sign In']");
            private By pageText = By.xpath("//*[text()='Sign in to continue.']");
			
			public EstimatorLoginPage(WebDriver driver, Logger log) {
				super(driver,log);
					
				}
			
		
			public String getCaptchaText() {
				return find(Getcaptcha).getText();
			}
			
			// Execute Login
			public LGMJobsPage logIn(String username, String password) {
				log.info("Executing login with username ["+username+"] and password ["+password+"]");
				type(username,usernameLocator);
				type(password,passwordLocator);
				type(getCaptchaText(),EnterCaptcha);
				click(logInButtonLocator);
				return new LGMJobsPage(driver, log);
			}

			public void openPage() {
				log.info("opening page: " + pageUrl);
				openUrl(pageUrl);
				log.info("Page opened!");
				
			}
			public String getPageText() {
				log.info("Login page varification start");
				waitForVisibilityOf(pageText,Duration.ofSeconds(10));
				return driver.findElement(pageText).getText();
			}
			
			public void InvalidCaptch() {
				log.info("Login with invalid cptach");
				 driver.findElement(By.id("EnterCaptcha")).sendKeys("uek8i");
			}
			
			

		}



