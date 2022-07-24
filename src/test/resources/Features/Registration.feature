@Registration
Feature: Registration form

   Scenario: Register account for Individual person
     Given Links web site registration is open
     And Registration form for individual person is populated
     Then Registration mail is successfully sent for account activation

   Scenario: Register account for legal entity
     Given Links web site registration is open
     And Registration form for legal entity is populated
     Then Registration mail is successfully sent for account activation