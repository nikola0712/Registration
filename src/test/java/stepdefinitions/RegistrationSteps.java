package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import pageobject.RegistrationPage;

import java.io.IOException;

public class RegistrationSteps extends RegistrationPage {
    @Given("Links web site registration is open")
    public void registrationPage() throws IOException {
        setUpRegistration();
    }

    @And("Registration form for individual person is populated")
    public void populateRegistrationFormIndividualPerson() {
        populateRegistrationFormForIndividual();
    }

    @And("Registration form for legal entity is populated")
    public void populateRegistrationFormLegalEntity() throws InterruptedException {
        populateRegistrationFormForLegalEntity();
    }

    @Then("Registration mail is successfully sent for account activation")
    public void registrationMailSent() {
        registrationMailForAccountActivation();
        tearDown();
    }
}
