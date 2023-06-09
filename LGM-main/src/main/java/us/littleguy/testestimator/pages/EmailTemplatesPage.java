package us.littleguy.testestimator.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailTemplatesPage extends BasePageObject{
	
	private By AddNewTemplate = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//form[@class='modal-form']//button[@title='Add new template']");
	private By templateName = By.xpath("/html//input[@id='templateName']");
	private By templateSubject = By.xpath("/html//input[@id='templateSubject']");
	private By saveButton = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//button[.=' Save ']");
	private By pageTitle = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//form[@class='modal-form']//h4[.='EMAIL TEMPLATE']");
	private By message = By.xpath("/html//div[@id='root']/div[@class='container-scroller']//div[@class='Toastify__toast Toastify__toast--success']/div[@role='alert']");
	private By editIcon = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']/div/div[@class='content-wrapper p-0']//table[@class='table table-striped']/tbody/tr[1]/th/span/i[@title='Edit template']");
	private By templatenameInGridOfFirstRow = By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(2)");
	private By backIcon = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//span[@title='Back']");
	
	public EmailTemplatesPage(WebDriver driver, Logger log)  {
		super(driver, log);
	}
	
	public void ClickOnAddNewTemplate() {
		log.info("Clicking on add icon");
		click(AddNewTemplate);
	}
	
	public void ClickOnEditIcon() {
		log.info("Clicking on edit icon");
		click(editIcon);
	}
	public void ClickOnBackIcon() {
		log.info("Clicking on back icon");
		click(backIcon);
	}
	
	public void addEmailTemplate(String TemplateName, String TemplateSubject)  {
		log.info("Adding details and clicking on save button");
		type(TemplateName, templateName);
		type(TemplateSubject, templateSubject);
		click(saveButton);
	}
	
	public void updateEmailTemplate(String TemplateName)  {
		log.info("Updating template name and clicking on save button");
		clearText(templateName);
		type(TemplateName, templateName);
		click(saveButton);
	}
	
	public String gettemplateNameFromFirstRow() {
		waitForVisibilityOf(templatenameInGridOfFirstRow,Duration.ofSeconds(10));
		return driver.findElement(templatenameInGridOfFirstRow).getText();
	}
	
	public boolean isTitleVisible() {
		waitForVisibilityOf(pageTitle,Duration.ofSeconds(10));
		return find(pageTitle).isDisplayed();
	}
	
	public String getMessage() {
		waitForVisibilityOf(message,Duration.ofSeconds(10));
		return driver.findElement(message).getText();
	}

}
