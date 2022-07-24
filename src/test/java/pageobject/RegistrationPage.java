package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import org.junit.Assert;
import com.github.javafaker.Faker;
import selectors.Selectors;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
public class RegistrationPage extends BaseClass {

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
    public static String randomName() {
        Faker faker = new Faker();
        return faker.letterify("User???Test?");
    }
    public static String randomPassword() {
        Faker faker = new Faker();
        return faker.bothify("NtoP???1#??249???!");
    }
    public static String randomCompanyAddress() {
        Faker faker = new Faker();
        return faker.letterify("????????? ???????");
    }
    public static String randomTelephone() {
        Faker faker = new Faker();
        return faker.numerify("+38164#######");
    }
    public static String randomCompanyOIB() {
        Faker faker = new Faker();
        return faker.numerify("###########");
    }
    public void populateRegistrationFormForIndividual() {
        //wait for page to load element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.id(Selectors.gender)));

        String password = randomPassword();

        WebElement genderButton = driver.findElement(By.id(Selectors.gender));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", genderButton);

        //populate mandatory fields
        driver.findElement(By.id(Selectors.firstName)).sendKeys(randomName());
        driver.findElement(By.id(Selectors.lastName)).sendKeys(randomName());

        Select dateOfBirthDay = new Select(driver.findElement(By.name(Selectors.dateOfBirthDay)));
        dateOfBirthDay.selectByVisibleText("7");
        Select DateOfBirthMonth = new Select(driver.findElement(By.name(Selectors.dateOfBirthMonth)));
        DateOfBirthMonth.selectByVisibleText("lipanj");
        Select dateOfBirthYear = new Select(driver.findElement(By.name(Selectors.dateOfBirthYear)));
        dateOfBirthYear.selectByVisibleText("2000");

        driver.findElement(By.id(Selectors.email)).sendKeys(randomEmail());
        driver.findElement(By.id(Selectors.password)).sendKeys(password);
        driver.findElement(By.id(Selectors.confirmPassword)).sendKeys(password);

        //click on register button
        driver.findElement(By.id(Selectors.registerButton)).click();
    }
    public void populateRegistrationFormForLegalEntity() throws InterruptedException {
        //wait for page to load element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.id(Selectors.registerAsCompany)));

        String password = randomPassword();

        //populate mandatory fields
        WebElement checkboxLegalEntity = driver.findElement(By.id(Selectors.registerAsCompany));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkboxLegalEntity);

        wait.until(visibilityOfElementLocated(By.id(Selectors.company)));
        driver.findElement(By.id(Selectors.company)).sendKeys(randomName());
        driver.findElement(By.id(Selectors.companyOIB)).sendKeys(randomCompanyOIB());
        driver.findElement(By.id(Selectors.companyEmail)).sendKeys(randomEmail());
        driver.findElement(By.id(Selectors.companyTelephone)).sendKeys(randomTelephone());
        driver.findElement(By.id(Selectors.companyContactPerson)).sendKeys(randomName());
        driver.findElement(By.id(Selectors.companyAddress)).sendKeys(randomCompanyAddress());
        this.sleep(3);

        WebElement postalNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Selectors.addressAutoComplete)));
        postalNumber.click();
        postalNumber.clear();
        postalNumber.sendKeys("11");
        this.sleep(5);
        postalNumber.sendKeys(Keys.ARROW_DOWN);
        postalNumber.sendKeys(Keys.ENTER);

        driver.findElement(By.id(Selectors.firstName)).sendKeys(randomName());
        driver.findElement(By.id(Selectors.lastName)).sendKeys(randomName());
        driver.findElement(By.id(Selectors.email)).sendKeys(randomEmail());
        driver.findElement(By.id(Selectors.password)).sendKeys(password);
        driver.findElement(By.id(Selectors.confirmPassword)).sendKeys(password);

        //click on register button
        driver.findElement(By.id(Selectors.registerButton)).click();
    }
    public void registrationMailForAccountActivation() {
        String expectedMailActivationText = "Poslan vam je e-mail koji sadrži upute za aktivaciju članstva.";
        String actualMailActivationText = driver.findElement(By.xpath(Selectors.result)).getText();
        Assert.assertTrue(actualMailActivationText.contains(expectedMailActivationText));
    }

    public void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }
}
